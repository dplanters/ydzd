package com.gndc.common.enums.right;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum RightPlatformEnum {

    /**
     * 运营
     */
    OPERATOR((byte) 2, "运营"),

    /**
     * 商户
     */
    PARTNER((byte) 3, "商户"),

    /**
     * App
     */
    APP((byte) 4, "APP");

    private Byte code;
    private String name;

    private static final Map<Byte, RightPlatformEnum> map;

    static {
        map = new HashMap<>();
        for (RightPlatformEnum as : values()) {
            map.put(as.code, as);
        }
    }

    RightPlatformEnum(Byte code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getName(Byte code) {
        for (RightPlatformEnum userSexType : RightPlatformEnum.values()) {
            if (userSexType.code.equals(code)) {
                return userSexType.name;
            }
        }
        return null;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static RightPlatformEnum fetch(Byte code) {
        return map.get(code);
    }

    /**
     * 根据编码获取名称
     *
     * @param code
     * @return
     */
    public static String fetchName(Byte code) {
        RightPlatformEnum as = map.get(code);
        return as != null ? as.name : null;
    }

}
