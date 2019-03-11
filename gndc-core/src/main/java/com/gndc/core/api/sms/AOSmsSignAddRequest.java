package com.gndc.core.api.sms;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
public class AOSmsSignAddRequest extends RequestMessage {

    /**
     * 签名名称
     */
    @NotBlank
    private String name;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.AO_SMS_MANAGER_SIGN_MANAGER_SIGN_ADD);
    }
}
