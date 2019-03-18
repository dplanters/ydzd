package com.gndc.third.sms.paasoo.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 手机格式错误代码
 *
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description
 * @date 2018年3月19日 下午2:01:56
 */
public enum PaasooPhoneNumberErrcodeType {

    ERRCODE_00("00", "调用成功"),

    ERRCODE_01("01", "欠费"),

    ERRCODE_02("02", "用户名或密码错误"),

    ERRCODE_06("06", "缺少参数"),

    ERRCODE_07("07", "白名单限制");

    private static final Map<String, PaasooPhoneNumberErrcodeType> map;

    static {
        map = new HashMap<>();
        for (PaasooPhoneNumberErrcodeType as : values()) {
            map.put(as.code, as);
        }
    }

    private String code;
    private String desc;

    PaasooPhoneNumberErrcodeType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static PaasooPhoneNumberErrcodeType fetch(String code) {
        return map.get(code);
    }

    /**
     * 根据编码获取描述
     *
     * @param code
     * @return
     */
    public static String fetchDesc(String code) {
        PaasooPhoneNumberErrcodeType as = map.get(code);
        return as != null ? as.desc : null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
