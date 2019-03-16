package com.gndc.common.enums.partner;

import java.util.HashMap;
import java.util.Map;

public enum EventFeeType {

    H5((byte) 1, "H5"),

    API((byte) 2, "API"),

    ;

    private static final Map<Byte, EventFeeType> map;

    static {
        map = new HashMap<>();
        for (EventFeeType palt : values()) {
            map.put(palt.code, palt);
        }
    }

    public byte code;
    private String name;

    EventFeeType(byte code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static EventFeeType fetch(byte code) {
        return map.get(code);
    }

    /**
     * 根据编码获取名称
     *
     * @param code
     * @return
     */
    public static String fetchName(byte code) {
        EventFeeType palt = map.get(code);
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
