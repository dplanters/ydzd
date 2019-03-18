package com.gndc.common.enums.partner;

import java.util.HashMap;
import java.util.Map;

public enum PartnerAccountLogTypeEnum {

    RECHARGET((byte) 1, "充值"),

    WITHDRAW((byte) 2, "提现");

    private static final Map<Byte, PartnerAccountLogTypeEnum> map;

    static {
        map = new HashMap<>();
        for (PartnerAccountLogTypeEnum palt : values()) {
            map.put(palt.code, palt);
        }
    }

    private byte code;
    private String name;

    PartnerAccountLogTypeEnum(byte code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static PartnerAccountLogTypeEnum fetch(byte code) {
        return map.get(code);
    }

    /**
     * 根据编码获取名称
     *
     * @param code
     * @return
     */
    public static String fetchName(byte code) {
        PartnerAccountLogTypeEnum palt = map.get(code);
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
