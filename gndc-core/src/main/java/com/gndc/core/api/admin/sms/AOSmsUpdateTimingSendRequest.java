package com.gndc.core.api.admin.sms;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AOSmsUpdateTimingSendRequest extends AOSmsRealTimeSendRequest {

    /**
     * 任务id
     */
    private Integer jobId;
    /**
     * 发送类型1循环发送 2非循环发送
     */
    @NotNull
    private Byte timingSendType;

    /**
     * 非循环发送：发送日期
     */
    private String sendDate;

    /**
     * 发送时间
     */
    @NotBlank
    private String sendTime;

    /**
     * 循环发送：循环开始日期
     */
    private String sendStartDate;

    /**
     * 循环发送：循环结束日期
     */
    private String sendEndDate;

    /**
     * 循环发送：周
     */
    private Integer[] weeks;
}
