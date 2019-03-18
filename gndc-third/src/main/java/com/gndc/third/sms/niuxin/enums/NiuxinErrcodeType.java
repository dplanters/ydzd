package com.gndc.third.sms.niuxin.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 状态报告异常状态错误代码
 *
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description
 * @date 2018年3月19日 下午2:01:56
 */
public enum NiuxinErrcodeType {

    ERRCODE_0("0", "请求成功"),

    ERRCODE_01("01", "应用app_key或secret_key错误"),

    ERRCODE_02("02", "客户不存在或accountsid无效"),

    ERRCODE_03("03", "参数错误或为空"),

    ERRCODE_04("04", "余额不足"),

    ERRCODE_05("05", "非法关键字"),

    ERRCODE_06("06", "短信内容为空"),

    ERRCODE_07("07", "短信内容过长(中国400字符,国际1000字节)"),

    ERRCODE_08("08", "号码有误"),

    ERRCODE_09("09", "时间戳异常"),

    ERRCODE_10("10", "sign不正确"),

    ERRCODE_11("11", "模板和内容不能同时为空"),

    ERRCODE_12("12", "模板不可用"),

    ERRCODE_13("13", "签名不可用"),

    ERRCODE_14("14", "中国短信必须使用带签名的模板"),

    ERRCODE_15("15", "变量参数个数与模板变量个数不符"),

    ERRCODE_16("16", "单个变量长度不得超过30"),

    ERRCODE_17("17", "群发号码数量不得超过100个"),

    ERRCODE_18("18", "sourceadd必须为3-10位数字或英文字母"),

    ERRCODE_19("19", "扩展码有误,支持1-8位数字"),

    ERRCODE_88("88", "请求失败"),

    ERRCODE_99("99", "系统错误"),
    ;

    private static final Map<String, NiuxinErrcodeType> map;

    static {
        map = new HashMap<>();
        for (NiuxinErrcodeType as : values()) {
            map.put(as.code, as);
        }
    }

    private String code;
    private String desc;

    NiuxinErrcodeType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static NiuxinErrcodeType fetch(String code) {
        return map.get(code);
    }

    /**
     * 根据编码获取描述
     *
     * @param code
     * @return
     */
    public static String fetchDesc(String code) {
        NiuxinErrcodeType as = map.get(code);
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
