package com.gndc.third.sms.tornado;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.gndc.common.constant.Constant;
import com.gndc.common.enums.sms.SmsTemplateType;
import com.gndc.common.utils.HttpClientUtil;
import com.gndc.third.sms.ISmsService;

import lombok.extern.slf4j.Slf4j;

@PropertySource(value = "classpath:/third.properties")
@Service("tornadoSmsService")
@Slf4j
public class TornadoSmsService implements ISmsService {

	@Value("${TORNADO_KEY}")
	private String API_KEY;

	@Value("${TORNADO_SECRET}")
	private String API_SECRET;

	@Value("${TORNADO_DEBUG}")
	private boolean DEBUG;

	// 编码格式。发送编码格式统一用UTF-8
	@Value("${TORNADO_ENCODING}")
	private String ENCODING;

	// 短信发送url
	@Value("${TORNADO_URI_GET_SEND_SMS}")
	private String URI_GET_SEND_SMS;

	// 短信发送url
	/*
	 * @Value("${TORNADO_URI_GET_SEND_SMS_INT}") private String
	 * URI_GET_SEND_SMS_INT;
	 */

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
			// 合作机构已经加了国家代码，我们无需加

			if (phone.indexOf(0) == 0) {
				phone = phone.substring(1);
			}
			if (phone.indexOf(Constant.COUNTRY_CODE) != 0) {
				phone = Constant.COUNTRY_CODE + phone;
			}

			Map<String, String> params = new HashMap<>();

			params.put("un", API_KEY);
			params.put("pw", API_SECRET);
			// 消息编码
			params.put("dc", "15");// 15代表中文
			// 短信内容
			params.put("sm", URLEncoder.encode(message, "utf8"));
			// 短信内容传输编码，设为 3 即可，3 为 URLEncoder - UTF8 编码
			params.put("tf", "3");
			// 手机号码
			params.put("da", phone);
			// 返回格式固定为 2，返回 JSON 格式
			params.put("rf", "2");
			// 是否需要状态报告（设为 1 为需要，0 为不需要），设为 1 就行
			params.put("rd", "1");

			String response = HttpClientUtil.get(URI_GET_SEND_SMS, params, ENCODING);
			log.info("sendsms response:" + response);

			// 成功 ::{"success": true, "id": "163403400105815633"}
			// 失败 : {"success": false, "r": "错误编号"}
			// 发送失败9020时，查看平台是否号码段没配置
			sendResult = JSONObject.parseObject(response, new TypeReference<Map<String, String>>() {
			});
			sendResult.put("response", response);
		}
		result.putAll(sendResult);
		log.info("sendsms sendResult:" + JSONObject.toJSONString(result));
		return result;
	}

	@Override
	public Map<String, String> marketSms(String phone, String message) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> sendIntSms(String phone, String message) {
		// TODO Auto-generated method stub
		return null;
	}
}
