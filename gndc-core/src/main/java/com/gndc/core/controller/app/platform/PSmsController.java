package com.gndc.core.controller.app.platform;

import com.gndc.common.constant.CacheConstant;
import com.gndc.common.constant.Constant;
import com.gndc.common.enums.ResultCode;
import com.gndc.common.enums.message.SMSTypeEnum;
import com.gndc.common.enums.sms.SmsChannelEnum;
import com.gndc.common.enums.sms.SmsTemplateType;
import com.gndc.common.exception.HjException;
import com.gndc.common.utils.JsonUtil;
import com.gndc.common.utils.PhoneUtil;
import com.gndc.common.utils.Utils;
import com.gndc.core.api.app.platform.PSendSmsRequest;
import com.gndc.core.api.app.platform.Sms10MinuteCount;
import com.gndc.core.api.app.platform.Sms24HourCount;
import com.gndc.core.api.common.CommonResponse;
import com.gndc.core.api.common.ResponseMessage;
import com.gndc.core.model.User;
import com.gndc.core.service.sms.SmsLogService;
import com.gndc.core.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户端发短信相关
 */
@RestController
@RequestMapping("/app/sms")
public class PSmsController {

    private static final Logger logger = LoggerFactory.getLogger(PSmsController.class);

    private static final String P_SMS_USER_FORGET_PWD = "P_SMS_USER_FORGET_PWD";

    private static final String P_SMS_USER_LOGIN = "P_SMS_USER_LOGIN";

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private SmsLogService smsLogService;


    @PostMapping("/send")
    public ResponseMessage<CommonResponse> sendSmsUserForgetPWD(@Validated @RequestBody PSendSmsRequest sendSmsRequest) throws InterruptedException {

        ResponseMessage<CommonResponse> response = new ResponseMessage<>();

        String phone = sendSmsRequest.getPhone();

        if (!PhoneUtil.checkPhone(phone)) {
            throw new HjException(ResultCode.PHONE_WRONG);
        }

        Byte type = sendSmsRequest.getType();
        String key = "";
        SmsTemplateType smsTemplateType = null;
        if (SMSTypeEnum.FORGET_PWD.getCode() == type) {
            // 查询手机号是否注册
            User user = userService.selectOneByProperty("phone", phone);
            if (user == null) {
                response.createError(ResultCode.USER_NOT_EXISTS);
                return response;
            }
            key = P_SMS_USER_FORGET_PWD + phone;
            smsTemplateType = SmsTemplateType.USER_FORGET_PWD;
        } else if (SMSTypeEnum.REGISTER.getCode() == type) {
            key = P_SMS_USER_LOGIN + phone;
            smsTemplateType = SmsTemplateType.USER_LOGIN;
        }

        String sms10MinuteCountStr = redisTemplate.opsForValue().get(CacheConstant.KEY_USER_SMS_10_PREFIX + key);
        String sms24HourCountStr = redisTemplate.opsForValue().get(CacheConstant.KEY_USER_SMS_24H_PREFIX + key);

        Sms10MinuteCount sms10MinuteCount = JsonUtil.getObject(sms10MinuteCountStr, Sms10MinuteCount.class);
        Sms24HourCount sms24HourCount = JsonUtil.getObject(sms24HourCountStr, Sms24HourCount.class);



        if (!validateSmsCount(sms10MinuteCount, sms24HourCount, response)) {
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }

        // 生成4位短信验证码
        int valCode = Utils.getRandom(4);

        logger.info("-------" + valCode);
        // paasoo短信发送
        smsLogService.sendValCodeSms(SmsChannelEnum.CHUANGLAN.getCode(), phone, smsTemplateType, valCode, 0,
                key, sms10MinuteCount, sms24HourCount);

        return response;
    }

    /**
     * 发送验证码时校验是否条数超限
     *
     * @param sms10MinuteCount
     * @param response
     * @return
     * @Description
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */
    private boolean validateSmsCount(Sms10MinuteCount sms10MinuteCount, Sms24HourCount sms24HourCount,
                                     ResponseMessage<?> response) {

        if (sms10MinuteCount == null) {
            sms10MinuteCount = new Sms10MinuteCount();
        }

        if (sms10MinuteCount.getFailCount() >= Constant.SMS_FAIL_COUNT_LIMIT) {
            response.createError(ResultCode.AUTH_FAIL_COUNT);
            // logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return false;
        }

        if (sms10MinuteCount.getCount() >= Constant.SMS_COUNT_LIMIT_TEN_MINTUE) {
            response.createError(ResultCode.AUTH_COUNT_TEN_LIMIT);
            // logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return false;
        }

        if (sms24HourCount == null) {
            sms24HourCount = new Sms24HourCount();
        }
        if (sms24HourCount.getCount() >= Constant.SMS_COUNT_LIMIT_24_HOUR) {
            response.createError(ResultCode.AUTH_COUNT_24_HOUR);
            // logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return false;
        }

        return true;
    }

}
