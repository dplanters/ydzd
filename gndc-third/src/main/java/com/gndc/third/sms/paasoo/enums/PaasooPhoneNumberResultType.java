package com.gndc.third.sms.paasoo.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 手机格式校验结果代码
 *
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description
 * @date 2018年3月19日 下午2:01:56
 */
public enum PaasooPhoneNumberResultType {

    RESULT_0("0", "无效号码"),

    RESULT_1("1", "格式正确");

    private static final Map<String, PaasooPhoneNumberResultType> map;

    static {
        map = new HashMap<>();
        for (PaasooPhoneNumberResultType as : values()) {
            map.put(as.code, as);
        }
    }

    private String code;
    private String desc;

    PaasooPhoneNumberResultType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static PaasooPhoneNumberResultType fetch(String code) {
        return map.get(code);
    }

    /**
     * 根据编码获取描述
     *
     * @param code
     * @return
     */
    public static String fetchDesc(String code) {
        PaasooPhoneNumberResultType as = map.get(code);
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
