package com.gndc.admin.api.admin.sms;

import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AOSmsSignListRequest extends RequestMessage {

    /**
     * 签名名称
     */
    private String name;

    /**
     * 创建时间开始
     */
    private String createTimeStart;

    /**
     * 创建时间结束
     */
    private String createTimeEnd;
}
