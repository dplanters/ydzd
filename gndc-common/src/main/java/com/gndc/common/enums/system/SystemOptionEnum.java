package com.gndc.common.enums.system;

/**
 * 系统配置相关
 */
public enum SystemOptionEnum {
    REQUEST_URL("REQUEST_URL", "接口请求地址"),
    UV_EVENT_FEE("UV_EVENT_FEE", "UV点击收费金额"),
    SEARCH_CRITERIA("SEARCH_CRITERIA_FIND", "找贷款搜索配置项");

    private String code;
    private String name;

    SystemOptionEnum(String code, String name) {
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
