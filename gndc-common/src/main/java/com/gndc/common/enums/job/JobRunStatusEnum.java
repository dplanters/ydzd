package com.gndc.common.enums.job;

import java.util.HashMap;
import java.util.Map;

/**
 * 任务运行状态
 */
public enum JobRunStatusEnum {
    STATUS_NOT_RUNNING((byte) 0, "停止"),

    STATUS_RUNNING((byte) 1, "开始");

    private static final Map<Byte, JobRunStatusEnum> map;

    static {
        map = new HashMap<>();
        for (JobRunStatusEnum as : values()) {
            map.put(as.code, as);
        }
    }

    private byte code;
    private String name;

    JobRunStatusEnum(byte code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static JobRunStatusEnum fetch(byte code) {
        return map.get(code);
    }

    /**
     * 根据编码获取名称
     *
     * @param code
     * @return
     */
    public static String fetchName(byte code) {
        JobRunStatusEnum as = map.get(code);
        return as != null ? as.name : null;
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
