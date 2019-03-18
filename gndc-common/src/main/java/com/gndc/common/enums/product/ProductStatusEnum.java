package com.gndc.common.enums.product;

import java.util.HashMap;
import java.util.Map;


public enum ProductStatusEnum {

    NOT_ON_LINE((byte) 1, "未上线"),

    ON_LINE((byte) 2, "上线"),

    OFF_LINE((byte) -1, "已下线"),
    ;

    private static final Map<Byte, ProductStatusEnum> map;

    static {
        map = new HashMap<>();
        for (ProductStatusEnum as : values()) {
            map.put(as.code, as);
        }
    }

    private byte code;
    private String name;

    ProductStatusEnum(byte code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static ProductStatusEnum fetch(byte code) {
        return map.get(code);
    }

    /**
     * 根据编码获取名称
     *
     * @param code
     * @return
     */
    public static String fetchName(byte code) {
        ProductStatusEnum as = map.get(code);
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
