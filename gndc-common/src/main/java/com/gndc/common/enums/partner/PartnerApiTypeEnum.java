package com.gndc.common.enums.partner;

import java.util.HashMap;
import java.util.Map;

/**
 * 商户API对接接口类型枚举
 */
public enum PartnerApiTypeEnum {

    /**
     * 判断用户是否可贷款
     */
    LOAN_JUDGEMENT((byte) 1, "LOAN_JUDGEMENT"),

    /**
     * 一推，对订单基本信息进行推送
     */
    FIRST_PUSH((byte) 5, "FIRST_PUSH"),
    ;

    private static final Map<Byte, PartnerApiTypeEnum> map;

    static {
        map = new HashMap<>();
        for (PartnerApiTypeEnum palt : values()) {
            map.put(palt.code, palt);
        }
    }

    public byte code;
    private String name;

    PartnerApiTypeEnum(byte code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static PartnerApiTypeEnum fetch(byte code) {
        return map.get(code);
    }

    /**
     * 根据编码获取名称
     *
     * @param code
     * @return
     */
    public static String fetchName(byte code) {
        PartnerApiTypeEnum palt = map.get(code);
        return palt != null ? palt.name : null;
    }

    public byte getCode() {
        return code;
    }

    public void setCode(byte code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
