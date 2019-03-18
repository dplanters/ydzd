package com.gndc.third.sms.paasoo.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 状态报告异常状态错误代码
 *
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description
 * @date 2018年3月19日 下午2:01:56
 */
public enum PaasooDrErrcodeType {

    ERRCODE_1("1", "未知错误"),

    ERRCODE_2("2", "消息无法送达（停机、关机、无信号等）"),

    ERRCODE_3("3", "号码已停止使用或无效号码"),

    ERRCODE_4("4", "用户拒收短信"),

    ERRCODE_5("5", "信息被运营商拒绝"),

    ERRCODE_99("99", "其他运营商错误");

    private static final Map<String, PaasooDrErrcodeType> map;

    static {
        map = new HashMap<>();
        for (PaasooDrErrcodeType as : values()) {
            map.put(as.code, as);
        }
    }

    private String code;
    private String desc;

    PaasooDrErrcodeType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static PaasooDrErrcodeType fetch(String code) {
        return map.get(code);
    }

    /**
     * 根据编码获取描述
     *
     * @param code
     * @return
     */
    public static String fetchDesc(String code) {
        PaasooDrErrcodeType as = map.get(code);
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
