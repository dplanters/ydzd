package com.gndc.core.api.admin.sms;


import com.gndc.core.api.common.RequestMessage;

/**
 * 短信管理-短信统计-请求
 */
public class AOSmsStatisticsRequest extends RequestMessage {


    /**
     * 开始时间
     */
    private String startDate;

    /**
     * 结束时间
     */
    private String endDate;

}
