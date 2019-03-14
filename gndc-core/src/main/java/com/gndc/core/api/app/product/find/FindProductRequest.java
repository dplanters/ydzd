package com.gndc.core.api.app.product.find;


import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindProductRequest extends RequestMessage {
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

}
