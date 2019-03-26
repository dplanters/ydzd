package com.gndc.core.api.admin.sms;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AOSmsConditionAddRequest extends RequestMessage {

    /**
     * 类型 0-未定义 1-营销类 2-催收类 3-提醒类 4-通知类
     */
    @NotNull
    private Byte type;

    /**
     * 短信条件内容
     */
    @NotNull
    private SmsConditionContent smsConditionContent;

}
