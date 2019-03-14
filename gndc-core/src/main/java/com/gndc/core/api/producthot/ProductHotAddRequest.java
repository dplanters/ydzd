package com.gndc.core.api.producthot;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductHotAddRequest extends RequestMessage {

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

}
