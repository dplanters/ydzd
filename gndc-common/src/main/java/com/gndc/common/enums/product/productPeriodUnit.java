package com.gndc.common.enums.product;

import java.util.HashMap;
import java.util.Map;

public enum productPeriodUnit {

    /**
     * 日
     */
    day((byte) 1, "日"),

    /**
     * 月
     */
    month((byte) 2, "月"),

    ;

    private static final Map<Byte, productPeriodUnit> map;

    static {
        map = new HashMap<>();
        for (productPeriodUnit palt : values()) {
            map.put(palt.code, palt);
        }
    }

    private byte code;
    private String name;

    productPeriodUnit(byte code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static productPeriodUnit fetch(byte code) {
        return map.get(code);
    }

    /**
     * 根据编码获取名称
     *
     * @param code
     * @return
     */
    public static String fetchName(byte code) {
        productPeriodUnit palt = map.get(code);
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
