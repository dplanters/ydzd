package com.gndc.core.api.partner.common;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

public class APAllPartnerRequest extends RequestMessage {

    private static final long serialVersionUID = 1L;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.A_PARTNER_INFO);
    }

}
