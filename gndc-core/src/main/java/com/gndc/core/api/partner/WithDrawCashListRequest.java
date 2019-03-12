package com.gndc.core.api.partner;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class WithDrawCashListRequest extends RequestMessage {
    private static final long serialVersionUID = 1L;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.A_PARTNER_WITHDRAW_LIST);
    }

}