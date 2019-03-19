package com.gndc.core.api.app.product.find;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PFindProductRequest extends RequestMessage {


    private static final long serialVersionUID = 4252234378456355619L;
    //金额区间开始
    @NotNull
    private Integer amountStart;
    //金额区间结束
    @NotNull
    private Integer amountEnd;
    //搜索条件
    private String optionKey;

}
