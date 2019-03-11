package com.gndc.core.api.sms;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AOSmsChannelAllRequest extends RequestMessage {

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.AO_SMS_CHANNEL_ALL);
    }
}
