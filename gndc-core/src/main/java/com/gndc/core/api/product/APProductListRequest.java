package com.gndc.core.api.product;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class APProductListRequest extends RequestMessage {

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.AP_PRODUCT_SETTING_LIST);
    }
}
