package com.gndc.core.api.product;

import java.math.BigDecimal;

public class ProductDataMoneyRequest {
    private Integer id;
    private BigDecimal dayRate;
    private BigDecimal borrowAmount;
    private Integer borrowPeriod;

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

    public BigDecimal getDayRate() {
        return dayRate;
    }

    public void setDayRate(BigDecimal dayRate) {
        this.dayRate = dayRate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
