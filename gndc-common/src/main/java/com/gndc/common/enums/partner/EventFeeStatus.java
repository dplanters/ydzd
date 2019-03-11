package com.gndc.common.enums.partner;

import java.util.HashMap;
import java.util.Map;

public enum EventFeeStatus {

    /**
     * 未结算
     */
    UNCOMPLETE((byte) 0, "未结算"),

    /**
     * 已结算
     */
    COMPLETE((byte) 1, "已结算"),

    ;

    private static final Map<Byte, EventFeeStatus> map;

    static {
        map = new HashMap<>();
        for (EventFeeStatus palt : values()) {
            map.put(palt.code, palt);
        }
    }

    private byte code;
    private String name;

    EventFeeStatus(byte code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static EventFeeStatus fetch(byte code) {
        return map.get(code);
    }

    /**
     * 根据编码获取名称
     *
     * @param code
     * @return
     */
    public static String fetchName(byte code) {
        EventFeeStatus palt = map.get(code);
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
