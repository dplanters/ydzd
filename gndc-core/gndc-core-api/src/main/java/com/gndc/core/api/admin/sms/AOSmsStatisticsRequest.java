package com.gndc.core.api.admin.sms;


import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * 短信管理-短信统计-请求
 */
@Getter
@Setter
public class AOSmsStatisticsRequest extends RequestMessage {

    /**
     * 统计维度 1:日发送统计 2:月发送统计
     */
    @NotNull
    private Byte type;
    /**
     * 开始时间
     */
    private String startDate;

    /**
     * 结束时间
     */
    private String endDate;

}
