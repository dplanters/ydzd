package com.gndc.common.enums.partner;

import java.util.HashMap;
import java.util.Map;

public enum EventFeeTypeEnum {

    H5((byte) 1, "H5"),

    API((byte) 2, "API"),

    ;

    private static final Map<Byte, EventFeeTypeEnum> map;

    static {
        map = new HashMap<>();
        for (EventFeeTypeEnum palt : values()) {
            map.put(palt.code, palt);
        }
    }

    public byte code;
    private String name;

    EventFeeTypeEnum(byte code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static EventFeeTypeEnum fetch(byte code) {
        return map.get(code);
    }

    /**
     * 根据编码获取名称
     *
     * @param code
     * @return
     */
    public static String fetchName(byte code) {
        EventFeeTypeEnum palt = map.get(code);
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
