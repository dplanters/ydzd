package com.gndc.core.api.producthot;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

public class ProductHotAddRequest extends RequestMessage {
    private static final long serialVersionUID = 1L;

    // 产品名字
    private String productName;
    // 固定排序
    private int productsort;

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
     * @return productsort
     */
    public int getProductsort() {
        return productsort;
    }

    /**
     * @param productsort 要设置的 productsort
     */
    public void setProductsort(int productsort) {
        this.productsort = productsort;
    }

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.PRODHOT_ADD);
    }

}
