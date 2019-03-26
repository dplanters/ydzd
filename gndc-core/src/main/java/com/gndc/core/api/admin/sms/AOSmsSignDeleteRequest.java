package com.gndc.core.api.admin.sms;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
public class AOSmsSignDeleteRequest extends RequestMessage {

    /**
     * 签名id
     */
    private Integer signId;
}
