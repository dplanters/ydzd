/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.third.sms.niuxin;

import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.SecureUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.gndc.common.constant.Constant;
import com.gndc.common.enums.sms.SmsTemplateType;
import com.gndc.common.utils.HttpClientUtil;
import com.gndc.third.sms.ISmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description
 * @date 2018年6月14日 下午2:28:10
 */
@Configuration
@PropertySource(value = "classpath:/third.properties")
@Service("niuxSmsService")
public class NiuxinService implements ISmsService {

    private static Logger logger = LoggerFactory.getLogger(NiuxinService.class);

    // private static final String CN = Constant.COUNTRY_CODE;

    @Value("${NIUXIN_KEY}")
    private String API_KEY;

    @Value("${NIUXIN_SECRET}")
    private String API_SECRET;

    @Value("${NIUXIN_SENDER_ID}")
    private String SENDER_ID;

    // 编码格式。发送编码格式统一用UTF-8
    @Value("${NIUXIN_ENCODING}")
    private String ENCODING;

    // 短信发送url
    @Value("${NIUXIN_URI_GET_SEND_SMS}")
    private String URI_GET_SEND_SMS;

    // 余额查询url
    @Value("${NIUXIN_URI_GET_USER_BALANCE}")
    private String URI_GET_USER_BALANCE;

    @Value("${NIUXIN_DEBUG}")
    private boolean DEBUG;

    // 短信发送url
    @Value("${NIUXIN_URI_GET_SEND_SMS_INT}")
    private String URI_GET_SEND_SMS_INT;

    @Override
    public Map<String, String> sendSms(String phone, String message, SmsTemplateType smsType) throws Exception {
        // 返回结果
        Map<String, String> result = new HashMap<String, String>();
        // 发送结果
        Map<String, String> sendResult = new HashMap<>();

        if (DEBUG) {
            // {"result":"提交成功","code":"0","info":"请求成功","messageid":"74078a0090f17e "}
            sendResult.put("result", "提交成功");
            sendResult.put("code", "0");
            sendResult.put("info", "请求成功");
            sendResult.put("messageid", "74078a0090f17e");
        } else {

            if (phone.indexOf(0) == 0) {
                phone = phone.substring(1);
            }
            if (phone.indexOf(Constant.COUNTRY_CODE) != 0) {
                phone = Constant.COUNTRY_CODE + phone;
            }

            Map<String, String> params = new HashMap<>();

            params.put("appkey", API_KEY);
            params.put("secretkey", API_SECRET);

            String timestamp = String.valueOf(DateUtil.date().getTime());
            params.put("timestamp", timestamp);

            String sign = SecureUtil.md5(API_KEY + API_SECRET + timestamp).toUpperCase();
            params.put("sign", sign);

            params.put("signaid", SENDER_ID);
            params.put("phone", phone);
            params.put("content", message);

            String response = HttpClientUtil.get(URI_GET_SEND_SMS, params, ENCODING);
            logger.info("sendsms response:" + response);

            // 成功 : {"bannerStatus":"0","messageid":"015bd4-d6dfa7-58w"}
            // 失败 : {"status_code":"Missing params.","bannerStatus":"2"}
            sendResult = JSONObject.parseObject(response, new TypeReference<Map<String, String>>() {
            });

            sendResult.put("response", response);
        }

        result.putAll(sendResult);

        logger.info("sendsms sendResult:" + JSONObject.toJSONString(result));
        return result;
    }

    /**
     * Description
     *
     * @param phone
     * @param message
     * @return
     * @throws Exception
     * @see com.ps.hjxjd.third.sms.ISmsService#marketsms(String,
     * String)
     */
    @Override
    public Map<String, String> marketSms(String phone, String message) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, String> sendIntSms(String phone, String message) {
        // 返回结果
        Map<String, String> result = new HashMap<String, String>();

        return result;
    }

}
