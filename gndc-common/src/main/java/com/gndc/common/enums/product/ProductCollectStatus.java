package com.gndc.common.enums.product;

public enum ProductCollectStatus {
    COLLECT((byte) 1, "收藏"),
    CANCEL_COLLECT((byte) -1, "取消收藏");

    private byte code;

    private String name;


    ProductCollectStatus(byte code, String name) {
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
