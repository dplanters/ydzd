package com.gndc.common.enums.system;

/**
 * 系统配置相关
 */
public enum SystemConfigGroupKeyEnum {


    //
    PRODUCT("PRODUCT", "产品group"),//具体是 PRODUCT+产品id
    PRODUCT_BANK_LIST("PRODUCT_BANK_LIST", "产品银行卡列表group"),
    PRODUCT_LABEL_LIST("PRODUCT_LABEL_LIST", "产品标签列表group");

    private String code;
    private String name;

    SystemConfigGroupKeyEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
