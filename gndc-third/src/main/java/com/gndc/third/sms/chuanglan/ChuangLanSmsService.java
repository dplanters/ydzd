package com.gndc.third.sms.chuanglan;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.gndc.common.enums.sms.SmsTemplateType;
import com.gndc.common.utils.JsonUtil;
import com.gndc.third.sms.ISmsService;
import com.gndc.third.sms.chuanglan.enums.ChuangLanStatusType;
import com.gndc.third.sms.chuanglan.util.ChuangLanSmsUtil;
import com.gndc.third.sms.chuanglan.util.SmsSendRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 短信http接口的java代码调用示例 基于Apache HttpClient 4.X
 */
@PropertySource(value = "classpath:/third.properties")
@Service
public class ChuangLanSmsService implements ISmsService {

    private static Logger logger = LoggerFactory.getLogger(ChuangLanSmsService.class);

    // private static final String CN = Constant.COUNTRY_CODE;

    @Value("${CHUANG_LAN_ACCOUNT}")
    private String CHUANG_LAN_ACCOUNT;

    @Value("${CHUANG_LAN_PASSWORD}")
    private String CHUANG_LAN_PASSWORD;

    @Value("${CHUANGLAN_SMS_SEND}")
    private String CHUANGLAN_SMS_SEND;

    @Value("${CHUANGLAN_DEBUG}")
    private boolean DEBUG;

    /**
     * 短信发送
     *
     * @param from
     * @param to
     * @param text
     * @return @
     * @Description
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */

    public Map<String, String> sendSms(String to, String text, SmsTemplateType smsType) throws Exception {

        // 发送结果
        Map<String, String> sendResult = new HashMap<String, String>();

        if (DEBUG) {
            sendResult.put("phoneValidateFormat", "1");
            sendResult.put("phoneValidateStr",
                    "{\"requestId\":\"200090-ca43bb-3000\",\"msgId\":\"200090-ca43bb-3000\",\"to\":\"6283113551239\",\"format\":1,\"errorCode\":\"00\",\"cc\":\"62\",\"countryIso\":\"ID\",\"mccmnc\":\"51008\",\"operator\":\"PTXLAxiataTbk(XL)\"}");
            sendResult.put("phoneValidateErrorCode", "00");
            sendResult.put("phoneValidateFormat", "1");

            sendResult.put("response", "{\"bannerStatus\":\"0\",\"messageid\":\"000090-ca43c5-4000\"}");
            sendResult.put("messageid", "000090-ca43c5-4000");
            sendResult.put("code", "0");
        } else {

            // 状态报告
            String report = "true";

            SmsSendRequest smsSingleRequest = new SmsSendRequest(CHUANG_LAN_ACCOUNT, CHUANG_LAN_PASSWORD, text, to,
                    report, UUID.randomUUID().toString().replace("-", ""));
            String requestJson = JSON.toJSONString(smsSingleRequest);

            System.out.println("chuanglan sms request: " + requestJson);

            String response = ChuangLanSmsUtil.sendSmsByPost(CHUANGLAN_SMS_SEND, requestJson);

            if (StrUtil.isBlank(response)) {
                sendResult.put("response", ChuangLanStatusType.REQUEST_NO_RESPONSE_FAILED.getDesc());
                sendResult.put("code", ChuangLanStatusType.REQUEST_NO_RESPONSE_FAILED.getStatus());
            }

            System.out.println("chuanglan sms response:" + response);

            sendResult = JsonUtil.getObject(response, new TypeReference<Map<String, String>>() {
            });

            sendResult.put("response", response);

        }
        return sendResult;
    }

    /**
     * Description
     *
     * @param phone
     * @param message
     * @return
     */
    @Override
    public Map<String, String> marketSms(String phone, String message) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}