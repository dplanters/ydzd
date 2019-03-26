package com.gndc.core.api.admin.sms;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AOSmsSignUpdateRequest extends RequestMessage {

    /**
     * 签名id
     */
    @NotNull
    private Integer signId;
    /**
     * 签名名称
     */
    private String name;

    /**
     * 通道id
     */
    private String channelId;
}
