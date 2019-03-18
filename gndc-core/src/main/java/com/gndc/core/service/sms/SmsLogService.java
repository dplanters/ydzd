package com.gndc.core.service.sms;

import com.gndc.common.enums.sms.SmsTemplateType;
import com.gndc.common.service.BaseService;
import com.gndc.core.api.app.platform.Sms10MinuteCount;
import com.gndc.core.api.app.platform.Sms24HourCount;
import com.gndc.core.api.app.platform.SmsInfo;
import com.gndc.core.api.common.ResponseMessage;
import com.gndc.core.model.SmsLog;

public interface SmsLogService extends BaseService<SmsLog, Integer> {
    /**
     * 发送验证码类短信
     *
     * @param channel          短信通道
     * @param phone            手机号
     * @param smsTemplateType  短信模版
     * @param valCode          验证码
     * @param userId           用户id
     * @param key              缓存key
     * @param sms10MinuteCount 10分钟内短信限制
     * @param sms24HourCount   24小时内短信限制
     * @return
     * @Description
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */
    void sendValCodeSms(String channel, String phone, SmsTemplateType smsTemplateType, int valCode, int userId, String key, Sms10MinuteCount sms10MinuteCount, Sms24HourCount sms24HourCount) throws InterruptedException;

    boolean validateSmsCount(Sms10MinuteCount sms10MinuteCount, Sms24HourCount sms24HourCount, ResponseMessage<?> response);

    boolean validateSms(SmsInfo sms, Sms10MinuteCount sms10MinuteCount, String key, String valCode, ResponseMessage<?> response);
}
