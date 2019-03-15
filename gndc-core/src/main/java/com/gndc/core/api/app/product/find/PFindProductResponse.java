package com.gndc.core.api.app.product.find;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class PFindProductResponse implements Serializable {


    private static final long serialVersionUID = 4352845841015162189L;

    /**
     * 产品Id
     */
    private Integer productId;

    private BigDecimal minBorrowAmount;

    private BigDecimal maxBorrowAmount;

    private String androidLink;

    private String iosLink;
    /**
     * 日利率
     */
    private BigDecimal dayRate;
    private String amountRange;
    private String periodRange;
    private String name;
    private String minDayRate;
    private Integer minBorrowPeriod;
    private Integer maxBorrowPeriod;
    /**
     * 1:日2:月
     */
    private Byte borrowPeriodUnit;
    /**
     * 放款时间描述
     */
    private String borrowTimeDescription;
    private String logoUrl;
    private String description;
    private Integer fixedSortType;
    private BigDecimal borrowAmountBegin;
    private BigDecimal borrowAmountEnd;
    /**
     * 是否添加产品详情
     */
    private Byte isDetail;

    private Byte dataType;
    /**
     * 产品UV统计
     */
    private int staticUV;
    /**
     * 产品周期
     */
    private String period;


}
