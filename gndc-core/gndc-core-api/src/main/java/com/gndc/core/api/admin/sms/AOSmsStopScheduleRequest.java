package com.gndc.core.api.admin.sms;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AOSmsStopScheduleRequest {

    /**
     * 任务id
     */
    @NotNull
    private Integer jobId;
}
