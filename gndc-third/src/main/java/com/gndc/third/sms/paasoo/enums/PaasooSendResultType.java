package com.gndc.third.sms.paasoo.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 提交至PaaSoo云通讯平台的响应状态码
 *
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description
 * @date 2018年3月19日 下午2:01:56
 */
public enum PaasooSendResultType {

    SUCCESS("0", "成功"),

    MISSING_PARAMS("2", "缺少必要参数"),

    INVALID_CREDENT("4", "Key或Secret错误"),

    INVALID_IP("5", "IP限制"),

    INVALID_PHONE_NUMBER("6", "IP限制"),

    INVALID_SENDER("7", "from参数格式错误"),

    QUOTA_EXCEEDED("9", "欠费或信用额度不足");

    private static final Map<String, PaasooSendResultType> map;

    static {
        map = new HashMap<>();
        for (PaasooSendResultType as : values()) {
            map.put(as.status, as);
        }
    }

    private String status;
    private String statusCode;

    PaasooSendResultType(String status, String statusCode) {
        this.status = status;
        this.statusCode = statusCode;
    }

    /**
     * 根据编码获取状态
     *
     * @param status
     * @return
     */
    public static PaasooSendResultType fetch(String status) {
        return map.get(status);
    }

    /**
     * 根据编码获取名称
     *
     * @param status
     * @return
     */
    public static String fetchStatusCode(String status) {
        PaasooSendResultType as = map.get(status);
        return as != null ? as.statusCode : null;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

}
