package com.gndc.core.api.admin.sms;

import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AOSmsSignDeleteRequest extends RequestMessage {

    /**
     * 签名id
     */
    private Integer signId;
}
