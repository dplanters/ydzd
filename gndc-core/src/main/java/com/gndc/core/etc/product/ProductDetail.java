package com.gndc.core.etc.product;

import com.gndc.core.model.Product;

import java.util.List;

public class ProductDetail extends Product {
    private List<ProductDataExt> productData;

    private String borrowAmountStr;

    private String borrowPeriodStr;

    private byte hotStatus;

    private boolean collected;

    private List<ProductAmountModel> amountModelList;

    public List<ProductAmountModel> getAmountModelList() {
        return amountModelList;
    }

    public void setAmountModelList(List<ProductAmountModel> amountModelList) {
        this.amountModelList = amountModelList;
    }


    /**
     * @return hotStatus
     */
    public byte getHotStatus() {
        return hotStatus;
    }

    /**
     * @param hotStatus 要设置的 hotStatus
     */
    public void setHotStatus(byte hotStatus) {
        this.hotStatus = hotStatus;
    }

    public String getBorrowAmountStr() {
        return borrowAmountStr;
    }

    public void setBorrowAmountStr(String borrowAmountStr) {
        this.borrowAmountStr = borrowAmountStr;
    }

    public String getBorrowPeriodStr() {
        return borrowPeriodStr;
    }

    public void setBorrowPeriodStr(String borrowPeriodStr) {
        this.borrowPeriodStr = borrowPeriodStr;
    }


    public List<ProductDataExt> getProductData() {
        return productData;
    }

    public void setProductData(List<ProductDataExt> productData) {
        this.productData = productData;
    }

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }

}
