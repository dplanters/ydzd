package com.gndc.admin.api.admin.sms;

import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AOSmsTemplateDeleteRequest extends RequestMessage {

    /**
     * 模板ID
     */
    @NotNull
    private Integer templateId;
}
