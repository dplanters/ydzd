package com.gndc.core.service.task;


import com.alibaba.fastjson.JSONObject;
import com.gndc.common.enums.sms.SmsChannelEnum;
import com.gndc.core.model.SmsGroupLog;
import com.gndc.core.service.sms.SmsGroupLogService;
import com.gndc.third.sms.chuanglan.ChuangLanSmsService;
import com.gndc.third.sms.paasoo.PaasooSmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class SmsJobTask {

    @Autowired
    PaasooSmsService paasooSmsService;

    @Autowired
    ChuangLanSmsService chuangLanSmsService;

    @Autowired
    SmsGroupLogService smsGroupLogService;

    public void groupSendSmsJson(String channel, String phone, String smsText, SmsGroupLog smsGroupLog) throws Exception {
        Map<String, String> sendResult = new HashMap<>();

        if (channel.equals(SmsChannelEnum.PAASOO.getCode())) {
            sendResult = paasooSmsService.sendSms(phone, smsText, null);
        } else if (channel.equals(SmsChannelEnum.CHUANGLAN.getCode())) {
            sendResult = chuangLanSmsService.sendSms(phone, smsText, null);
        }
        // 短信群发发送日志
        if (channel.equals(SmsChannelEnum.PAASOO.getCode())) {

        } else if (channel.equals(SmsChannelEnum.CHUANGLAN.getCode())) {
            String failNum = sendResult.get("failNum");
            String successNum = sendResult.get("successNum");
            if (failNum != null) {
                smsGroupLog.setFailNum(Integer.parseInt(failNum));
            }
            if (successNum != null) {
                smsGroupLog.setSuccessNum(Integer.parseInt(successNum));
            }
            smsGroupLog.setUid(sendResult.get("uid"));
            log.info(JSONObject.toJSONString(sendResult));
            smsGroupLog.setPaasooPhoneValStr(sendResult.get("phoneValidateStr"));
        }

        smsGroupLogService.insertSelective(smsGroupLog);
    }
}
