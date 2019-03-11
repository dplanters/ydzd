package com.gndc.common.enums.common;

import java.util.HashMap;
import java.util.Map;


public enum Status {
    ALL((byte) 0, "全部状态"),

    NOT_ON_LINE((byte) 1, "未上线"),

    ON_LINE((byte) 2, "上线"),

    OFF_LINE((byte) -1, "已下线"),
    ;

    private static final Map<Byte, Status> map;

    static {
        map = new HashMap<>();
        for (Status as : values()) {
            map.put(as.code, as);
        }
    }

    private byte code;
    private String name;

    Status(byte code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static Status fetch(byte code) {
        return map.get(code);
    }

    /**
     * 根据编码获取名称
     *
     * @param code
     * @return
     */
    public static String fetchName(byte code) {
        Status as = map.get(code);
        return as != null ? as.name : null;
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
