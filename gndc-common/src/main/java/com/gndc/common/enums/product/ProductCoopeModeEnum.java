package com.gndc.common.enums.product;

import java.util.HashMap;
import java.util.Map;


public enum ProductCoopeModeEnum {
    CPI((byte) 1, "CPI"),
    CPA((byte) 2, "CPA"),
    CPL((byte) 3, "CPL"),
    CPS((byte) 4, "CPS"),
    CPC((byte) 5, "CPC"),
    ;
    private static final Map<Byte, ProductCoopeModeEnum> map;

    static {
        map = new HashMap<>();
        for (ProductCoopeModeEnum as : values()) {
            map.put(as.code, as);
        }
    }

    private Byte code;
    private String name;

    ProductCoopeModeEnum(byte code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static ProductCoopeModeEnum fetch(byte code) {
        return map.get(code);
    }

    /**
     * 根据编码获取名称
     *
     * @param code
     * @return
     */
    public static String fetchName(byte code) {
        ProductCoopeModeEnum as = map.get(code);
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
