package com.gndc.core.api.app.product.recommend;


import com.gndc.common.api.RequestMessage;

public class RecommendProductsRequest extends RequestMessage {
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
    }
}
