package com.gndc.third.sms.tornado.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Description
 * @author <a href="xuliqun8773@adpanshi.com">xuliqun</a>
 * @param code
 * @param desc
 */
public enum TornadoErrcodeType {
	ERRCODE_1("9002", "未知错误"),

	ERRCODE_2("9012", "短信消息内容错误"),

	ERRCODE_3("9013", "目标地址错误"),

	ERRCODE_4("9014", "短信内容太长"),

	ERRCODE_5("9015", "路由错误"),

	ERRCODE_6("9016", "没有下发网关"),

	ERRCODE_7("9017", "未知错误"),

	ERRCODE_8("9018", "短信消息内容错误"),

	ERRCODE_9("9019", "目标地址错误"),

	ERRCODE_10("9020", "短信内容太长"),

	ERRCODE_11("9021", "路由错误"),

	ERRCODE_12("9922", "没有下发网关"),

	ERRCODE_13("9023", "未知错误"),

	ERRCODE_14("9024", "短信消息内容错误"),

	ERRCODE_15("9025", "目标地址错误"),

	ERRCODE_16("9026", "短信内容太长"),

	ERRCODE_17("9027", "路由错误"),

	ERRCODE_18("9028", "没有下发网关");

	private static final Map<String, TornadoErrcodeType> map;

	static {
		map = new HashMap<>();
		for (TornadoErrcodeType as : values()) {
			map.put(as.code, as);
		}
	}

	private String code;
	private String desc;

	TornadoErrcodeType(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	/**
	 * 根据编码获取状态
	 *
	 * @param code
	 * @return
	 */
	public static TornadoErrcodeType fetch(String code) {
		return map.get(code);
	}

	/**
	 * 根据编码获取描述
	 *
	 * @param code
	 * @return
	 */
	public static String fetchDesc(String code) {
		TornadoErrcodeType as = map.get(code);
		return as != null ? as.desc : null;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
