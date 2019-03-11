package com.gndc.core.api.product;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class AOProductDataModifyRequest implements Serializable {

    /**
     * 日利率
     */
    private BigDecimal dayRate;

    /**
     * 借款周期开始
     */
    private Integer borrowPeriodStart;

    /**
     * 借款周期结束
     */
    private Integer borrowPeriodEnd;

    /**
     * 1:日2:月
     */
    private Byte borrowPeriodUnit;

    /**
     * 放款时间描述
     */
    private String borrowTimeDescription;

}
