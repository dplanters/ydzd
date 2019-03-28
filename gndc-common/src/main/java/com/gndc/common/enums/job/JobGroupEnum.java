package com.gndc.common.enums.job;

import java.util.HashMap;
import java.util.Map;

/**
 * 任务分组
 */
public enum JobGroupEnum {

    SMS_TIMING_SEND("SMS_TIMING_SEND", "短信定时发送任务组");

    private static final Map<String, JobGroupEnum> map;

    static {
        map = new HashMap<>();
        for (JobGroupEnum as : values()) {
            map.put(as.code, as);
        }
    }

    private String code;
    private String name;

    JobGroupEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static JobGroupEnum fetch(byte code) {
        return map.get(code);
    }

    /**
     * 根据编码获取名称
     *
     * @param code
     * @return
     */
    public static String fetchName(byte code) {
        JobGroupEnum as = map.get(code);
        return as != null ? as.name : null;
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
