package com.gndc.core.api.producthot;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

public class ProductHotListRequest extends RequestMessage {
    private static final long serialVersionUID = 1L;

    // 产品名称
    private String productName;
    // 状态
    private byte status;

    /**
     * @return productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName 要设置的 productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return status
     */
    public byte getStatus() {
        return status;
    }

    /**
     * @param status 要设置的 status
     */
    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.PRODHOT_LIST);
    }

}
