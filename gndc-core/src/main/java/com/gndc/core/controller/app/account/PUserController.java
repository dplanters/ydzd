package com.gndc.core.controller.app.account;

import com.alibaba.fastjson.JSONObject;
import com.gndc.common.enums.ResultCode;
import com.gndc.common.enums.common.StatusEnum;
import com.gndc.common.enums.feedback.FeedbackStatusTypeEnum;
import com.gndc.common.enums.message.MessageTypeEnum;
import com.gndc.common.enums.partner.EventFeeStatusEnum;
import com.gndc.common.enums.partner.EventFeeTypeEnum;
import com.gndc.common.enums.product.ProductCoopeModeEnum;
import com.gndc.common.enums.user.UserEventsTypeEnum;
import com.gndc.common.exception.HjException;
import com.gndc.common.utils.DateUtil;
import com.gndc.core.api.app.user.event.PUserEventRequest;
import com.gndc.core.api.app.user.feedback.PFeedBackEditRequest;
import com.gndc.core.api.common.CommonResponse;
import com.gndc.core.api.common.ResponseMessage;
import com.gndc.core.model.*;
import com.gndc.core.service.partner.EventFeeService;
import com.gndc.core.service.platform.FeedbackService;
import com.gndc.core.service.platform.MessageTemplateService;
import com.gndc.core.service.platform.UserMessageService;
import com.gndc.core.service.product.ProductService;
import com.gndc.core.service.user.UserEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RestController
@RequestMapping("/app/user")
public class PUserController {

    private static final Logger logger = LoggerFactory.getLogger(PUserController.class);

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

        User user = feedBackEditRequest.getUser();
        if (user == null) {
            throw new HjException(ResultCode.SESSIONID_ISNULL);
        }

        Date now = DateUtil.getCountyTime();
        UserFeedback feedback = new UserFeedback();
        feedback.setUserId(user.getId());
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

        User user = eventRequest.getUser();
        if (user == null) {
            throw new HjException(ResultCode.SESSIONID_ISNULL);
        }

        int ref = 0;
        if (eventRequest.getType() == (int) UserEventsTypeEnum.OPEN_APP.getCode()) {
            ref =  userEventService.statisticsUserOpenApp(user.getId(), eventRequest.getHeader().getIp());
        } else {

            if (eventRequest.getProductId() == 0) {
                throw new HjException(ResultCode.PARAM_MISSING);
            }
            Date now = DateUtil.getCountyTime();
            UserEvent event = new UserEvent();
            event.setUserId(user.getId());
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
                    message.setUserId(user.getId());
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

                Integer eventFeesCount = userEventService.selectUVCount(user.getId(), eventRequest.getProductId(), new Date(DateUtil.getStartTime()), currDate);
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
