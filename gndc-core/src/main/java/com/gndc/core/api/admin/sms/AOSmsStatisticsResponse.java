package com.gndc.core.api.admin.sms;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 短信管理-短信统计-响应
 */
@Getter
@Setter
public class AOSmsStatisticsResponse implements Serializable {

    /**
     * 日期
     */
    private Date startDate;

    /**
     * 发送总量
     */
    private Integer countSend;

    /**
     * 成功量
     */
    private Integer countSuccess;

    /**
     * 失败量
     */
    private Integer countFail;

}
