package com.gndc.core.api.product;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

import java.math.BigDecimal;

public class ProductSearchRequest extends RequestMessage {
    private static final long serialVersionUID = 1L;


    private String name;
    private Byte coopeMode;
    // 状态
    private Byte status;
    private BigDecimal borrowAmount;
    private Integer borrowPeriod;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getCoopeMode() {
        return coopeMode;
    }

    public void setCoopeMode(Byte coopeMode) {
        this.coopeMode = coopeMode;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public BigDecimal getBorrowAmount() {
        return borrowAmount;
    }

    public void setBorrowAmount(BigDecimal borrowAmount) {
        this.borrowAmount = borrowAmount;
    }

    public Integer getBorrowPeriod() {
        return borrowPeriod;
    }

    public void setBorrowPeriod(Integer borrowPeriod) {
        this.borrowPeriod = borrowPeriod;
    }

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.A_PRODUCT_LIST);

    }

}
