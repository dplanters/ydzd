package com.gndc.core.api.product;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

public class ProductCollectCheckRequest extends RequestMessage {
    private static final long serialVersionUID = 1L;
    private Integer userId;
    private Integer productId;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.P_USER_PRODUCT_COLLECT);

    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
