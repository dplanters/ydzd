package com.gndc.core.api.admin.sms;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

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
    @NotBlank
    private String channelId;
}
