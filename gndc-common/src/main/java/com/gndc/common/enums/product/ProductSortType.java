package com.gndc.common.enums.product;

public enum ProductSortType {
    FIXED((byte) -1, "固定排序"),
    NOT_FIXED((byte) 1, "不固定排序");

    private byte code;

    private String name;


    ProductSortType(byte code, String name) {
        this.code = code;
        this.name = name;
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
