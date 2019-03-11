package com.gndc.common.enums.partner;

import java.util.HashMap;
import java.util.Map;

public enum PartnerAccountLogType {

    RECHARGET((byte) 1, "充值"),

    WITHDRAW((byte) 2, "提现");

    private static final Map<Byte, PartnerAccountLogType> map;

    static {
        map = new HashMap<>();
        for (PartnerAccountLogType palt : values()) {
            map.put(palt.code, palt);
        }
    }

    private byte code;
    private String name;

    PartnerAccountLogType(byte code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static PartnerAccountLogType fetch(byte code) {
        return map.get(code);
    }

    /**
     * 根据编码获取名称
     *
     * @param code
     * @return
     */
    public static String fetchName(byte code) {
        PartnerAccountLogType palt = map.get(code);
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
