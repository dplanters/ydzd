package com.gndc.core.api.app.product.find;


import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

public class FindProductsRequest extends RequestMessage {
    private static final long serialVersionUID = 1L;

    private Byte sort;
    // 状态
    private Byte status;

    //金额区间开始
    private int amountStart;
    //金额区间结束
    private int amountEnd;
    //搜索条件
    private String optionKey;

    public String getOptionKey() {
        return optionKey;
    }

    public void setOptionKey(String optionKey) {
        this.optionKey = optionKey;
    }

    public int getAmountStart() {
        return amountStart;
    }

    public void setAmountStart(int amountStart) {
        this.amountStart = amountStart;
    }

    public int getAmountEnd() {
        return amountEnd;
    }

    public void setAmountEnd(int amountEnd) {
        this.amountEnd = amountEnd;
    }

    public Byte getSort() {
        return sort;
    }

    public void setSort(Byte sort) {
        this.sort = sort;
    }

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
