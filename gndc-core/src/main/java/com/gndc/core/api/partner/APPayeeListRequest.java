package com.gndc.core.api.partner;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class APPayeeListRequest extends RequestMessage {

    private static final long serialVersionUID = 1L;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.AP_PAYEE_LIST);
    }

}
