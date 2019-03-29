package com.gndc.core.api.admin.sms;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AOSmsTimingSendRequest extends AOSmsRealTimeSendRequest {

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
     * 非循环发送：发送时间
     */
    @NotNull
    private String[] sendTime;

    /**
     * 循环发送：循环开始日期
     */
    private String sendStartDate;

    /**
     * 循环发送：循环结束日期
     */
    private String sendEndDate;
}
