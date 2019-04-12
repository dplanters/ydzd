package com.gndc.third.sms.chuanglan;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.gndc.common.enums.sms.SmsTemplateType;
import com.gndc.third.sms.ISmsService;
import com.gndc.third.sms.chuanglan.enums.ChuangLanStatusType;
import com.gndc.third.sms.chuanglan.util.ChuangLanSmsUtil;
import com.gndc.third.sms.chuanglan.util.SmsSendRequest;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class ChuangLanSmsService implements ISmsService {

    // private static final String CN = Constant.COUNTRY_CODE;

    @Value("${CHUANG_LAN_ACCOUNT}")
    private String CHUANG_LAN_ACCOUNT;

    @Value("${CHUANG_LAN_PASSWORD}")
    private String CHUANG_LAN_PASSWORD;

    @Value("${CHUANGLAN_SMS_SEND}")
    private String CHUANGLAN_SMS_SEND;

    @Value("${CHUANGLAN_DEBUG}")
    private boolean DEBUG;

    @Value("${CHUANG_LAN_ACCOUNT_INT}")
    private String CHUANG_LAN_ACCOUNT_INT;

    @Value("${CHUANG_LAN_PASSWORD_INT}")
    private String CHUANG_LAN_PASSWORD_INT;

    @Value("${CHUANGLAN_SMS_SEND_INT}")
    private String CHUANGLAN_SMS_SEND_INT;

    /**
     * 短信发送
     *
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
            sendResult.put("msgId", "000090-ca43c5-4000");
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

            sendResult = JSONObject.parseObject(response, new TypeReference<Map<String, String>>() {
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

    @Override
    public Map<String, String> sendIntSms(String phone, String message) {
        // 发送结果
        Map<String, String> sendResult = new HashMap<String, String>();

        if (DEBUG) {
            sendResult.put("response", "{\"code\":\"0\",\"error\":\"\",\"msgid\":\"1053100497688465408\"}");
        } else {
            //组装请求参数
            JSONObject map = new JSONObject();
            map.put("account", CHUANG_LAN_ACCOUNT_INT);
            map.put("password", CHUANG_LAN_PASSWORD_INT);
            map.put("msg", message);
            map.put("mobile", phone);
            //map.put("senderId", senderId);

            String params = map.toString();

            log.info("请求参数为:" + params);
            try {
                String result = HttpUtil.post(CHUANGLAN_SMS_SEND_INT, params);
                log.info("返回参数为:" + result);
                sendResult.put("response", result);
            } catch (Exception e) {
                // TODO: handle exception
                log.error("请求异常：" + e);
            }
        }
        return null;
    }
}