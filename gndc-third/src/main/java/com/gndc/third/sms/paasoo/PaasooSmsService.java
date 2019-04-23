package com.gndc.third.sms.paasoo;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.gndc.common.constant.Constant;
import com.gndc.common.enums.sms.SmsTemplateType;
import com.gndc.common.utils.HttpClientUtil;
import com.gndc.third.sms.ISmsService;
import com.gndc.third.sms.paasoo.enums.PaasooNotSupporMccmnc;
import com.gndc.third.sms.paasoo.enums.PaasooPhoneNumberErrcodeType;
import com.gndc.third.sms.paasoo.enums.PaasooPhoneNumberResultType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 短信http接口的java代码调用示例 基于Apache HttpClient 4.X
 */
@Slf4j
@PropertySource(value = "classpath:/third.properties")
@Service
public class PaasooSmsService implements ISmsService {

    // private static final String CN = Constant.COUNTRY_CODE;

    @Value("${PAASOO_KEY}")
    private String API_KEY;

    @Value("${PAASOO_SECRET}")
    private String API_SECRET;

    @Value("${PAASOO_KEY_MARKET}")
    private String API_KEY_MARKET;

    @Value("${PAASOO_SECRET_MARKET}")
    private String API_SECRET_MARKET;

    @Value("${PAASOO_SENDER_ID}")
    private String SENDER_ID;

    // 编码格式。发送编码格式统一用UTF-8
    @Value("${PAASOO_ENCODING}")
    private String ENCODING;

    // 短信发送url
    @Value("${PAASOO_URI_GET_SEND_SMS}")
    private String URI_GET_SEND_SMS;

    // 发送记录查询url
    @Value("${PAASOO_URI_GET_SEND_RECORD}")
    private String URI_GET_SEND_RECORD;

    // 余额查询url
    @Value("${PAASOO_URI_GET_USER_BALANCE}")
    private String URI_GET_USER_BALANCE;

    // 号码格式验证url
    @Value("${PAASOO_URI_GET_VALID_NUMBER}")
    private String URI_GET_VALID_NUMBER;

    @Value("${PAASOO_DEBUG}")
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
        // 返回结果
        Map<String, String> result = new HashMap<String, String>();
        // 发送结果
        Map<String, String> sendResult = new HashMap<>();

        if (DEBUG) {
            sendResult.put("phoneValidateFormat", "1");
            sendResult.put("phoneValidateStr",
                    "{\"requestId\":\"200090-ca43bb-3000\",\"msgId\":\"200090-ca43bb-3000\",\"to\":\"6283113551239\",\"format\":1,\"errorCode\":\"00\",\"cc\":\"62\",\"countryIso\":\"ID\",\"mccmnc\":\"51008\",\"operator\":\"PTXLAxiataTbk(XL)\"}");
            sendResult.put("phoneValidateErrorCode", "00");
            sendResult.put("phoneValidateFormat", "1");

            sendResult.put("response", "{\"bannerStatus\":\"0\",\"messageid\":\"000090-ca43c5-4000\"}");
            sendResult.put("messageid", "000090-ca43c5-4000");
            sendResult.put("status", "0");
        } else {

            if (to.indexOf(0) == 0) {
                to = to.substring(1);
            }
            if (to.indexOf(Constant.COUNTRY_CODE) != 0) {
                to = Constant.COUNTRY_CODE + to;
            }
            log.info("cn:" + Constant.COUNTRY_CODE);
            Map<String, String> validNumberResult = getValidNumber(to);

            result.put("phoneValidateErrorCode", validNumberResult.get("errorCode"));
            result.put("phoneValidateFormat", validNumberResult.get("format"));
            result.put("phoneValidateStr", validNumberResult.get("response"));

            String mccmnc = validNumberResult.get("mccmnc");

            PaasooNotSupporMccmnc mccmncNotSuppor = PaasooNotSupporMccmnc.fetch(mccmnc);

            String errorCode = validNumberResult.get("errorCode");
            PaasooPhoneNumberErrcodeType phoneNumberErrcode = PaasooPhoneNumberErrcodeType.fetch(errorCode);

            // 调用成功
            if (phoneNumberErrcode == PaasooPhoneNumberErrcodeType.ERRCODE_00) {
                PaasooPhoneNumberResultType phoneValidateFormat = PaasooPhoneNumberResultType
                        .fetch(validNumberResult.get("format"));
                // 号码格式错误
                if (phoneValidateFormat != PaasooPhoneNumberResultType.RESULT_1) {
                    return validNumberResult;
                }

            }

            Map<String, String> params = new HashMap<String, String>();

            switch (smsType) {
                case USER_LOGIN:

                case USER_FORGET_PWD:
                    // 修改手机验证码，目前和注册模板相同
                case USER_MODIFY_PHONE:
                    // 银行卡绑定验证码
                case BANK_BIND:

                    // 如果是验证码类短信，并且短信通道不支持，直接返回
                    if (mccmncNotSuppor == PaasooNotSupporMccmnc.MCCMNC_ID_FIXED
                            || mccmncNotSuppor == PaasooNotSupporMccmnc.MCCMNC_ID_UNKNOWN) {
                        return validNumberResult;
                    }

                    params.put("key", API_KEY);
                    params.put("secret", API_SECRET);
                    break;

                default:
                    // 如果是营销类短信，并且短信通道不支持，直接返回
                    if (mccmncNotSuppor != null) {
                        return validNumberResult;
                    }

                    params.put("key", API_KEY_MARKET);
                    params.put("secret", API_SECRET_MARKET);

                    break;
            }

            params.put("from", SENDER_ID);
            params.put("to", to);
            params.put("text", text);

            String response = HttpClientUtil.get(URI_GET_SEND_SMS, params, ENCODING);
            log.info("sendsms response:" + response);

            // 成功 : {"bannerStatus":"0","messageid":"015bd4-d6dfa7-58w"}
            // 失败 : {"status_code":"Missing params.","bannerStatus":"2"}
            sendResult = JSONObject.parseObject(response, new TypeReference<Map<String, String>>() {
            });

            sendResult.put("response", response);
        }

        result.putAll(sendResult);

        log.info("sendsms sendResult:" + JSONObject.toJSONString(result));
        return result;

    }

    /**
     * 发送记录查询
     *
     * @param messageid
     * @return @
     * @Description
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */
    public Map<String, String> getSendRecord(String messageid) throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("key", API_KEY);
        params.put("secret", API_SECRET);
        params.put("messageid", messageid);

        String response = HttpClientUtil.get(URI_GET_SEND_RECORD, params, ENCODING);
        log.info("getSendRecord response:" + response);

        Map<String, String> result = JSONObject.parseObject(response, new TypeReference<Map<String, String>>() {
        });

        return result;
    }

    /**
     * 余额查询
     *
     * @return @
     * @Description
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */
    public Map<String, String> getUserBalance() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("key", API_KEY);
        params.put("secret", API_SECRET);

        String response = HttpClientUtil.get(URI_GET_USER_BALANCE, params, ENCODING);
        log.info("getUserBalance response:" + response);

        // 成功 : {"bannerStatus":"0","messageid":"015bd4-d6dfa7-58w"}
        // 失败 : {"status_code":"Missing params.","bannerStatus":"2"}
        Map<String, String> result = JSONObject.parseObject(response, new TypeReference<Map<String, String>>() {
        });

        return result;
    }

    /**
     * 电话号码校验
     *
     * @param countryCode
     * @param nationalNumber
     * @return @
     * @Description
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */
    public Map<String, String> getValidNumber(String countryCode, String nationalNumber) throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("key", API_KEY);
        params.put("secret", API_SECRET);
        params.put("countryCode", countryCode);
        params.put("nationalNumber", nationalNumber);

        String response = HttpClientUtil.get(URI_GET_VALID_NUMBER, params, ENCODING);
        log.info("getValidNumber response:" + response);

        // 成功 : {"bannerStatus":"0","messageid":"015bd4-d6dfa7-58w"}
        // 失败 : {"status_code":"Missing params.","bannerStatus":"2"}
        Map<String, String> result = JSONObject.parseObject(response, new TypeReference<Map<String, String>>() {
        });

        return result;
    }

    /**
     * 电话号码校验
     *
     * @param countryCode
     * @param nationalNumber
     * @return @
     * @Description
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */
    public Map<String, String> getValidNumber(String to) throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("key", API_KEY);
        params.put("secret", API_SECRET);
        params.put("to", to);

        String response = HttpClientUtil.get(URI_GET_VALID_NUMBER, params, ENCODING);
        log.info("getValidNumber response:" + response);

        // 成功 :
        // {"requestId":"200090-2367ec-0000","msgId":"200090-2367ec-0000","to":"8615990006398",
        // "format":1,"errorCode":"00","cc":"86","countryIso":"CN","mccmnc":"46000",}

        // 失败 :
        // {"requestId":"200090-24092e-3000","msgId":"200090-24092e-3000","to":"615990006398","format":0,"errorCode":"00","cc":"61","countryIso":"AU"}
        Map<String, String> result = JSONObject.parseObject(response, new TypeReference<Map<String, String>>() {
        });

        result.put("response", response);

        return result;
    }

    /**
     * 短信发送
     *
     * @param from
     * @param to
     * @param text
     * @return @
     * @Description
     * @author <a href="litianwei8504@adpanshi.com">litianwei</a>
     */

    public Map<String, String> marketSms(String to, String text) throws Exception {
        // 返回结果
        Map<String, String> result = new HashMap<String, String>();
        // 发送结果
        Map<String, String> sendResult = new HashMap<>();
        if (DEBUG) {
            sendResult.put("phoneValidateFormat", "1");
            sendResult.put("phoneValidateStr",
                    "{\"requestId\":\"200090-ca43bb-3000\",\"msgId\":\"200090-ca43bb-3000\",\"to\":\"6283113551239\",\"format\":1,\"errorCode\":\"00\",\"cc\":\"62\",\"countryIso\":\"ID\",\"mccmnc\":\"51008\",\"operator\":\"PTXLAxiataTbk(XL)\"}");
            sendResult.put("phoneValidateErrorCode", "00");
            sendResult.put("phoneValidateFormat", "1");
            sendResult.put("response", "{\"bannerStatus\":\"0\",\"messageid\":\"000090-ca43c5-4000\"}");
            sendResult.put("messageid", "000090-ca43c5-4000");
            sendResult.put("status", "0");
        } else {
            // 校验电话号码
            Map<String, String> validNumberResult = getValidNumber(to);

            result.put("phoneValidateErrorCode", validNumberResult.get("errorCode"));
            result.put("phoneValidateFormat", validNumberResult.get("format"));
            result.put("phoneValidateStr", validNumberResult.get("response"));
            result.put("messageid", validNumberResult.get("msgId"));

            String errorCode = validNumberResult.get("errorCode");
            PaasooPhoneNumberErrcodeType phoneNumberErrcode = PaasooPhoneNumberErrcodeType.fetch(errorCode);

            String mccmnc = validNumberResult.get("mccmnc");

            // 调用成功
            if (phoneNumberErrcode == PaasooPhoneNumberErrcodeType.ERRCODE_00) {
                PaasooPhoneNumberResultType phoneValidateFormat = PaasooPhoneNumberResultType
                        .fetch(validNumberResult.get("format"));
                // 号码格式错误
                if (phoneValidateFormat != PaasooPhoneNumberResultType.RESULT_1) {
                    return validNumberResult;
                }
                if (PaasooNotSupporMccmnc.fetch(mccmnc) != null) {
                    return validNumberResult;
                }
            }
            Map<String, String> params = new HashMap<String, String>();
            params.put("key", API_KEY_MARKET);
            params.put("secret", API_SECRET_MARKET);
            params.put("from", SENDER_ID);
            params.put("to", to);
            params.put("text", text);

            // 调用发送短信url
            String response = HttpClientUtil.get(URI_GET_SEND_SMS, params, ENCODING);
            log.info("sendsms response:" + response);

            // 成功 : {"bannerStatus":"0","messageid":"015bd4-d6dfa7-58w"}
            // 失败 : {"status_code":"Missing params.","bannerStatus":"2"}
            sendResult = JSONObject.parseObject(response, new TypeReference<Map<String, String>>() {
            });

            sendResult.put("response", response);
        }

        result.putAll(sendResult);

        log.info("sendsms sendResult:" + JSONObject.toJSONString(result));
        return result;
    }

    @Override
    public Map<String, String> sendIntSms(String phone, String message) {
        return null;
    }
}