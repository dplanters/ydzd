package com.gndc.common.enums.user;

public enum UserStatusType {
    PHONE_UNBIND((byte) -1, "未绑定手机号"),
    INFO_UNFILLED((byte) 1, "未填完资料"),
    INFO_FILLED((byte) 2, "已填完资料");

    private byte code;
    private String name;

    UserStatusType(byte code, String name) {
        this.code = code;
        this.name = name;
    }

    public static UserStatusType fetch(byte code) {
        for (UserStatusType userAuthType : UserStatusType.values()) {
            if (userAuthType.code == code) {
                return userAuthType;
            }
        }
        return null;
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
