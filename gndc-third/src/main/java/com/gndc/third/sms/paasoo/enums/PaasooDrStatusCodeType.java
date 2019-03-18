package com.gndc.third.sms.paasoo.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 状态报告状态值
 *
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description
 * @date 2018年3月19日 下午2:01:56
 */
public enum PaasooDrStatusCodeType {

    DELIVERED("delivered", "短信送达"),

    ACCEPTED("accepted", "运营商接收"),

    FAILED("failed", "发送失败"),

    REJECTED("rejected", "运营商拒绝"),

    UNKNOWN("unknown", "未知类型错误");

    private static final Map<String, PaasooDrStatusCodeType> map;

    static {
        map = new HashMap<>();
        for (PaasooDrStatusCodeType as : values()) {
            map.put(as.code, as);
        }
    }

    private String code;
    private String desc;

    PaasooDrStatusCodeType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static PaasooDrStatusCodeType fetch(String code) {
        return map.get(code);
    }

    /**
     * 根据编码获取描述
     *
     * @param code
     * @return
     */
    public static String fetchDesc(String code) {
        PaasooDrStatusCodeType as = map.get(code);
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
