package com.gndc.common.enums.partner;

import java.util.HashMap;
import java.util.Map;

public enum PartnerAccountLogStatus {

    RECHARGE_PROCESS((byte) 1, "充值中"),

    RECHARGE_FINISH((byte) 2, "充值成功"),

    WITHDRAW_PROCESS((byte) 3, "提现中"),

    WITHDRAW_FINISH((byte) 4, "提现成功");

    private static final Map<Byte, PartnerAccountLogStatus> map;

    static {
        map = new HashMap<>();
        for (PartnerAccountLogStatus palt : values()) {
            map.put(palt.code, palt);
        }
    }

    private byte code;
    private String name;

    PartnerAccountLogStatus(byte code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static PartnerAccountLogStatus fetch(byte code) {
        return map.get(code);
    }

    /**
     * 根据编码获取名称
     *
     * @param code
     * @return
     */
    public static String fetchName(byte code) {
        PartnerAccountLogStatus palt = map.get(code);
        return palt != null ? palt.name : null;
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
