package com.gndc.core.api.admin.sms;

import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AOSmsGroupLogListRequest extends RequestMessage {

    /**
     * 签名id
     */
    private Integer signId;

    /**
     * 创建时间开始
     */
    private String createTimeStart;

    /**
     * 创建时间结束
     */
    private String createTimeEnd;
}
