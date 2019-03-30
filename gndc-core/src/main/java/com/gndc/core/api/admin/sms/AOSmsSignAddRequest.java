package com.gndc.core.api.admin.sms;

import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AOSmsSignAddRequest extends RequestMessage {

    /**
     * 签名名称
     */
    @NotBlank
    private String name;
    /**
     * 通道id
     */
    @NotNull
    private Integer channelId;
}
