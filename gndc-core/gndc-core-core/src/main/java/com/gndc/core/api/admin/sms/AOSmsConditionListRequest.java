package com.gndc.core.api.admin.sms;

import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AOSmsConditionListRequest extends RequestMessage {

    /**
     * 类型 0-未定义 1-营销类 2-催收类 3-提醒类 4-通知类
     */
    private Byte type;

    /**
     * 创建时间开始
     */
    private String createTimeStart;

    /**
     * 创建时间结束
     */
    private String createTimeEnd;
}
