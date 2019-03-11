package com.gndc.core.api.product;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

public class ProductRecommendListRequest extends RequestMessage {
    private static final long serialVersionUID = 1L;

    private Byte status;


    public Byte getStatus() {
        return status;
    }


    public void setStatus(Byte status) {
        this.status = status;
    }


    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.P_PRODUCT_RECOMMEND_LIST);
    }
}
