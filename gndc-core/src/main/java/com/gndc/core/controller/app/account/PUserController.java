package com.gndc.core.controller.app.account;

import com.gndc.common.enums.ResultCode;
import com.gndc.common.enums.feedback.FeedbackStatusTypeEnum;
import com.gndc.common.utils.DateUtil;
import com.gndc.common.utils.JsonUtil;
import com.gndc.core.api.app.user.feedback.PFeedBackEditRequest;
import com.gndc.core.api.common.CommonResponse;
import com.gndc.core.api.common.ResponseMessage;
import com.gndc.core.model.User;
import com.gndc.core.model.UserFeedback;
import com.gndc.core.service.platform.FeedbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 客户端用户相关
 */
@RestController
@RequestMapping("/app/user")
public class PUserController {

    private static final Logger logger = LoggerFactory.getLogger(PUserController.class);

    @Autowired
    private FeedbackService feedbackService;

    /**
     * 用户编辑反馈
     *
     * @param feedBackEditRequest
     * @return
     */
    @RequestMapping("/feedback/edit")
    public ResponseMessage<CommonResponse> feedbackEdit(@Validated @RequestBody PFeedBackEditRequest feedBackEditRequest) {
        ResponseMessage<CommonResponse> response = new ResponseMessage<>();

        User user = feedBackEditRequest.getUser();
        if (user == null) {
            response.createError(ResultCode.SESSIONID_ISNULL);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }

        Date now = DateUtil.getCountyTime();
        UserFeedback feedback = new UserFeedback();
        feedback.setUserId(user.getId());
        feedback.setUserPhone(feedBackEditRequest.getPhone());
        feedback.setContent(feedBackEditRequest.getContent().replaceAll("[\ud800\udc00-\udbff\udfff\ud800-\udfff]", ""));
        feedback.setCreateTime(now);
        feedback.setStatus(FeedbackStatusTypeEnum.SUBMIT.getCode());
        feedback.setPictureUrl(feedBackEditRequest.getFeedbackPictureUrl());
        int ret = feedbackService.insertSelective(feedback);
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setResult(ret);
        response.setData(commonResponse);
        return response;
    }
}
