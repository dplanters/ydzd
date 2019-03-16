package com.gndc.common.enums.right;

import lombok.Getter;

@Getter
public enum RightPlatformEnum {

    /**
     * 运营
     */
    OPERATOR((byte) 1, "运营"),

    /**
     * 商户
     */
    PARTNER((byte) 2, "商户");

    private byte code;
    private String name;

    RightPlatformEnum(byte code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getName(byte code) {
        for (RightPlatformEnum userSexType : RightPlatformEnum.values()) {
            if (userSexType.code == code) {
                return userSexType.name;
            }
        }
        return null;
    }

}
