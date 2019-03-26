package com.gndc.common.enums.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 在线状态
 */
public enum OnlineStatusEnum {

    NOT_ONLINE((byte)1, "未上线"),

    ONLINE((byte)2, "上线"),

    OFFLINE((byte)-1, "下线");

    private static final Map<Byte, OnlineStatusEnum> map;

    static {
        map = new HashMap<>();
        for (OnlineStatusEnum as : values()) {
            map.put(as.code, as);
        }
    }

    private Byte code;
    private String name;

    OnlineStatusEnum(Byte code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static OnlineStatusEnum fetch(Byte code) {
        return map.get(code);
    }

    /**
     * 根据编码获取名称
     *
     * @param code
     * @return
     */
    public static String fetchName(Byte code) {
        OnlineStatusEnum as = map.get(code);
        return as != null ? as.name : null;
    }

    public Byte getCode() {
        return code;
    }

    public void setCode(Byte code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
