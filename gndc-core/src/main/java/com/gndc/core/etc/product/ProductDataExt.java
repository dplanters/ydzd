package com.gndc.core.etc.product;

import com.gndc.core.model.ProductData;

import java.math.BigDecimal;

public class ProductDataExt extends ProductData {

    private BigDecimal interest;

    private BigDecimal repayAmount;


    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getRepayAmount() {
        return repayAmount;
    }

    public void setRepayAmount(BigDecimal repayAmount) {
        this.repayAmount = repayAmount;
    }

}
