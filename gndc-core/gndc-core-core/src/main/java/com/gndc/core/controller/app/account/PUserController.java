package com.gndc.core.controller.app.account;

import cn.hutool.core.date.DateUtil;
import com.gndc.common.api.ResponseMessage;
import com.gndc.common.dto.PUserLoginInfoDTO;
import com.gndc.common.enums.ResultCode;
import com.gndc.common.enums.common.StatusEnum;
import com.gndc.common.enums.feedback.FeedbackStatusTypeEnum;
import com.gndc.common.enums.message.MessageTypeEnum;
import com.gndc.common.enums.partner.EventFeeStatusEnum;
import com.gndc.common.enums.partner.EventFeeTypeEnum;
import com.gndc.common.enums.product.ProductCoopeModeEnum;
import com.gndc.common.enums.user.UserEventsTypeEnum;
import com.gndc.common.exception.HjException;
import com.gndc.core.api.app.user.event.PUserEventRequest;
import com.gndc.core.api.app.user.feedback.PFeedBackEditRequest;
import com.gndc.core.api.common.CommonResponse;
import com.gndc.core.model.*;
import com.gndc.core.service.partner.EventFeeService;
import com.gndc.core.service.platform.FeedbackService;
import com.gndc.core.service.platform.MessageTemplateService;
import com.gndc.core.service.platform.UserMessageService;
import com.gndc.core.service.product.ProductService;
import com.gndc.core.service.user.UserEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.weekend.Weekend;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

/**
 * 客户端用户相关
 */
@Slf4j
@RestController
@RequestMapping("/app/user")
public class PUserController {

    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserEventService userEventService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private MessageTemplateService messageTemplateService;

    @Autowired
    private UserMessageService userMessageService;

    @Autowired
    private EventFeeService eventFeeService;

    /**
     * 用户编辑反馈
     *
     * @param feedBackEditRequest
     * @return
     */
    @PostMapping("/feedback/edit")
    public ResponseMessage<CommonResponse> feedbackEdit(@Validated @RequestBody PFeedBackEditRequest feedBackEditRequest) {
        ResponseMessage<CommonResponse> response = new ResponseMessage<>();

        PUserLoginInfoDTO userInfo = feedBackEditRequest.getPUser();
        if (userInfo == null) {
            throw new HjException(ResultCode.INVALID_SESSION);
        }

        Date now = DateUtil.date().toJdkDate();
        UserFeedback feedback = new UserFeedback();
        feedback.setUserId(userInfo.getId());
        feedback.setUserPhone(feedBackEditRequest.getPhone());
        feedback.setContent(feedBackEditRequest.getContent().replaceAll("[\ud800\udc00-\udbff\udfff\ud800-\udfff]", ""));
        feedback.setCreateTime(now);
        feedback.setFeedbackStatus(FeedbackStatusTypeEnum.SUBMIT.getCode());
        feedback.setPictureUrl(feedBackEditRequest.getFeedbackPictureUrl());
        int ret = feedbackService.insertSelective(feedback);
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setResult(ret);
        response.setData(commonResponse);
        return response;
    }

    /**
     * 用户行为收集
     *
     * @param eventRequest
     * @return
     */
    @PostMapping("/event/collection")
    public ResponseMessage<CommonResponse> eventCollection(@Validated @RequestBody PUserEventRequest eventRequest) throws InterruptedException {
        ResponseMessage<CommonResponse> response = new ResponseMessage<>();

        PUserLoginInfoDTO userInfo = eventRequest.getPUser();
        if (userInfo == null) {
            throw new HjException(ResultCode.PARAMETER_CHECK_FAIL);
        }

        int ref = 0;
        if (eventRequest.getType() == (int) UserEventsTypeEnum.OPEN_APP.getCode()) {
            ref =  userEventService.statisticsUserOpenApp(userInfo.getId(), eventRequest.getHeader().getIp());
        } else {

            if (eventRequest.getProductId() == 0) {
                throw new HjException(ResultCode.PARAMETER_CHECK_FAIL);
            }
            Date now = DateUtil.date().toJdkDate();
            UserEvent event = new UserEvent();
            event.setUserId(userInfo.getId());
            event.setCreateTime(now);
            event.setEventType(eventRequest.getType());
            event.setProductId(eventRequest.getProductId());
            event.setEventTime(now);
            event.setUpdateTime(now);
            event.setIpAddress(eventRequest.getHeader().getIp());
            ref = userEventService.insertSelective(event);
            redisTemplate.execute(new RedisCallback<Long>() {
                @Override
                public Long doInRedis(RedisConnection connection) throws DataAccessException {
                    connection.incrBy(redisTemplate.getStringSerializer().serialize(UserEventsTypeEnum.fetch(eventRequest.getType()).getName()), 1);
                    return 1L;
                }
            });

            if (eventRequest.getType() == (int) UserEventsTypeEnum.DOWNLOAD_CLICK.getCode()) {
                Weekend<MessageTemplate> weekend = Weekend.of(MessageTemplate.class);
                weekend.weekendCriteria()
                        .andEqualTo(MessageTemplate::getStatus, StatusEnum.NORMAL.getCode())
                        .andEqualTo(MessageTemplate::getType,MessageTypeEnum.SYSTEM.getCode());
                List<MessageTemplate> messageTemplates = messageTemplateService.selectByExample(weekend);

                if (messageTemplates != null && messageTemplates.size() > 0) {
                    UserMessage message = new UserMessage();
                    MessageTemplate messageTemplate = messageTemplates.get(0);
                    Product product = productService.selectByPrimaryKey(eventRequest.getProductId());
                    String messageContent = MessageFormat.format(messageTemplate.getContent(), product.getName());
                    message.setUserId(userInfo.getId());
                    message.setMessage(messageContent);
                    message.setProductId(eventRequest.getProductId());
                    message.setMessageType(MessageTypeEnum.SYSTEM.getCode());
                    message.setMessageStatus(StatusEnum.NORMAL.getCode());
                    userMessageService.insertSelective(message);
                }
            }

            if (eventRequest.getType() == (int) UserEventsTypeEnum.BANNER_CLICK.getCode()
                    || eventRequest.getType() == (int) UserEventsTypeEnum.RECOMMEND_CLICK.getCode()
                    || eventRequest.getType() == (int) UserEventsTypeEnum.PRODUCT_CLICK.getCode()) {
                Product product = productService.selectByPrimaryKey(eventRequest.getProductId());
                Date currDate = new Date();

                Integer eventFeesCount = userEventService.selectUVCount(userInfo.getId(), eventRequest.getProductId(),
                        DateUtil.beginOfDay(DateUtil.date()).toJdkDate(),
                        currDate);
                if (eventFeesCount < 1) {
                    EventFee eventFee = new EventFee();
                    eventFee.setProductId(eventRequest.getProductId());
                    eventFee.setEventId(event.getId());
                    eventFee.setPartnerId(product.getPartnerId());
                    eventFee.setFee(product.getCoopePrice());
                    eventFee.setFeeType(EventFeeTypeEnum.H5.getCode());
                    eventFee.setEventType(eventRequest.getType());
                    eventFee.setCoopeMode(ProductCoopeModeEnum.CPC.getCode());
                    eventFee.setFeeStatus(EventFeeStatusEnum.UNCOMPLETE.getCode());
                    eventFeeService.insertSelective(eventFee);
                    eventFeeService.completeFee(eventFee.getId(), product.getPartnerId(), eventFee.getFee());
                }
            }
        }
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setResult(ref);
        response.setData(commonResponse);
        return response;
    }
}