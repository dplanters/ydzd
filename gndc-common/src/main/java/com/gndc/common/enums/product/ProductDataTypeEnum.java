package com.gndc.common.enums.product;

public enum ProductDataTypeEnum {
    AMOUNT((byte) 1, "借款数据"),
    QUESTION((byte) 2, "常见问题");

    private byte code;

    private String name;


    ProductDataTypeEnum(byte code, String name) {
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
