package com.gndc.core.api.sms;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
public class AOSmsChannelAddRequest extends RequestMessage {

    /**
     * 通道名称
     */
    @NotBlank
    private String name;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.AO_SMS_CHANNEL_CHANNEL_MANAGER_CHANNEL_ADD);
    }
}
