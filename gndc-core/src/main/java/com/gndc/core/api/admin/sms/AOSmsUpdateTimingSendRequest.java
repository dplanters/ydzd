package com.gndc.core.api.admin.sms;

import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AOSmsUpdateTimingSendRequest extends RequestMessage {

    /**
     * 渠道id 1创蓝2大汉三通
     */
    private Integer channelId;
    /**
     * 任务id
     */
    @NotNull
    private Integer jobId;

    /**
     * cron表达式
     */
    @NotBlank
    private String cronExpression;
}
