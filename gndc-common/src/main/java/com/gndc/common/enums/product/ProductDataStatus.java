package com.gndc.common.enums.product;

public enum ProductDataStatus {
    NORMAL((byte) 1, "正常"),
    DELETE((byte) -1, "删除");

    private byte code;

    private String name;


    ProductDataStatus(byte code, String name) {
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
