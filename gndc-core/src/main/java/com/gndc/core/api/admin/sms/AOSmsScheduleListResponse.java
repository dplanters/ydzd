package com.gndc.core.api.admin.sms;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AOSmsScheduleListResponse implements Serializable {
    /**
     * 任务id
     */
    private Integer jobId;

    /**
     * 创建时间开始
     */
    private String createTime;

    /**
     * 签名id
     */
    private String signIds;
    /**
     * 签名name
     */
    private String signNames;

    /**
     * 短信类型 0-未定义 1-营销类 2-催收类 3-提醒类 4-通知类
     */
    private Byte type;

    /**
     * 模板内容
     */
    private String content;
    /**
     * 条件
     */
    private String condition;
    /**
     * 条件(内容)
     */
    private String conditionText;
    /**
     * cron 表达式
     */
    private String expression;
    /**
     * 任务状态1：开始0：停止
     */
    private String jobStatus;
    /**
     * 通道id
     */
    private Integer channelId;
    /**
     * 用户来源1条件筛选 2导入
     */
    private Byte sourceType;
}
