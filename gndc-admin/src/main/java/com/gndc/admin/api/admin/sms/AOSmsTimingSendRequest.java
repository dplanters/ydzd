package com.gndc.admin.api.admin.sms;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class AOSmsTimingSendRequest extends AOSmsRealTimeSendRequest {
    /**
     * cron表达式
     */
    @NotBlank
    private String cronExpression;
}
