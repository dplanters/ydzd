package com.gndc.common.enums.sms;

import java.util.HashMap;
import java.util.Map;

/**
 * 短信通道类型
 *
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description
 * @date 2018年3月19日 下午2:01:56
 */
public enum SmsChannel {

    UNKNOWN("unkwon", "未知"),

    PAASOO("paasoo", "paasoo"),

    CHUANGLAN("chuanglan", "chuanglan"),

    NIUXIN("niuxin", "niuxin");

    private static final Map<String, SmsChannel> map;

    static {
        map = new HashMap<>();
        for (SmsChannel as : values()) {
            map.put(as.code, as);
        }
    }

    private String code;
    private String name;

    SmsChannel(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static SmsChannel fetch(String code) {
        return map.get(code);
    }

    /**
     * 根据编码获取名称
     *
     * @param code
     * @return
     */
    public static String fetchName(String code) {
        SmsChannel sc = map.get(code);
        return sc != null ? sc.name : null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
