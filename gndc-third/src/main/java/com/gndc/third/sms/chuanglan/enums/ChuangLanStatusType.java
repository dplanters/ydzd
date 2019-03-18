package com.gndc.third.sms.chuanglan.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 状态报告状态值
 *
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description
 * @date 2018年3月19日 下午2:01:56
 */
public enum ChuangLanStatusType {

    SUCCESS("0", "提交成功"),

    NO_SUCH_USER("101", "无此用户"),

    WRONG_PASSWORD("102", "密码错"),

    SUBMIT_SPEED_EXCEEDS_FLOW_RATE_LIMIT("103", "提交过快（提交速度超过流速限制）"),

    SUBMITTED_SMS_UNAVAILABLE_DUE_PLATFORM_SIDE_REASONS("104", "系统忙（因平台侧原因，暂时无法处理提交的短信）"),

    SMS_CONTENT_CONTAINS_SENSITIVE_WORDS("105", "敏感短信（短信内容包含敏感词）"),

    WRONG_MESSAGE_LENGTH("106", "消息长度错（>536 或<=0）"),

    INCORRECT_MOBILE_NUMBER("107", "包含错误的手机号码"),

    NUMBER_MOBILE_PHONE_NUMBERS_WRONG("108", "手机号码个数错（群发>1000 或<=0）"),

    NUMBER_AVAILABLE_SMS_MESSAGES_USER_USED("109", "无发送额度（该用户可用短信数已使用完）"),

    NOT_IN_THE_SENDING_TIME("110", "不在发送时间内"),

    EXTENDED_CODE_FORMAT_ERROR("113", "扩展码格式错（非数字或者长度不对）"),

    THE_NUMBER_OF_AVAILABLE_PARAMETER_GROUPS_INCORRECT("114", "可用参数组个数错误（小于最小设定值或者大于 1000）;变量参\n" + "数组大于 20 个"),

    SIGNATURE_IS_ILLEGAL_OR_NOT_SIGNED("116", "签名不合法或未带签名"),

    IP_ADDRESS_AUTHENTICATION_ERROR("117", "签名不合法或未带签名"),

    USER_NOT_HAVE_CORRESPONDING_SEND_PERMISSION("118", "用户没有相应的发送权限（账号被禁止发送）"),

    USER_HAS_EXPIRED("119", "用户已过期"),

    VIOLATION_OF_THEFT_PREVENTION_STRATEGY("120", "违反防盗用策略(日发送限制)"),

    SEND_TYPE_ERROR("123", "发送类型错误"),

    WHITE_TEMPLATE_MATCHING_ERROR("124", "白模板匹配错误"),

    MATCH_REJECTION_TEMPLATE_SUBMISSION_FAILED("125", "匹配驳回模板，提交失败"),

    TIMING_TRANSMISSION_TIME_FORMAT_ERROR("127", "定时发送时间格式错误"),

    CONTENT_ENCODING_FAILED("128", "内容编码失败"),

    JSON_FORMAT_ERROR("129", "JSON 格式错误"),

    REQUEST_PARAMETER_ERROR("130", "请求参数错误（缺少必填参数）"),

    REQUEST_NO_RESPONSE_FAILED("131", "请求无响应失败"),

    ;

    private static final Map<String, ChuangLanStatusType> map;

    static {
        map = new HashMap<>();
        for (ChuangLanStatusType as : values()) {
            map.put(as.status, as);
        }
    }

    private String status;
    private String desc;

    ChuangLanStatusType(String status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    /**
     * 根据编码获取状态
     *
     * @param status
     * @return
     */
    public static ChuangLanStatusType fetch(String status) {
        return map.get(status);
    }

    /**
     * 根据编码获取描述
     *
     * @param status
     * @return
     */
    public static String fetchDesc(String status) {
        ChuangLanStatusType as = map.get(status);
        return as != null ? as.desc : null;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
