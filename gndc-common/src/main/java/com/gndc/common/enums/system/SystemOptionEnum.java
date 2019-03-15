package com.gndc.common.enums.system;

/**
 * 系统配置相关
 */
public enum SystemOptionEnum {
    REQUEST_URL("REQUEST_URL", "接口请求地址"),

    UV_EVENT_FEE("UV_EVENT_FEE", "UV点击收费金额"),

    SEARCH_CRITERIA("SEARCH_CRITERIA_FIND", "找贷款搜索配置项"),

    WECHAT_SERVICE("WECHAT_SERVICE", "微信客服"),

    WECHAT_PUBLIC("WECHAT_PUBLIC", "微信公众号"),

    SERVICE_TEL("SERVICE_TEL", "客服电话");

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
