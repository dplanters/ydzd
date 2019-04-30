package com.gndc.admin.api.app.product.find;


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
    /**
     * 产品名称
     */
    private String name;

    private String androidLink;

    private String iosLink;
    /**
     * 一句话描述
     */
    private String description;
    /**
     * 放款时间描述
     */
    private String borrowTimeDescription;
    /**
     * 额度范围开始
     */
    private BigDecimal borrowAmountBegin;
    /**
     * 额度范围结束
     */
    private BigDecimal borrowAmountEnd;

    private String logoUrl;

    /**
     * 利率
     */
    private BigDecimal dayRate;
    /**
     * 利率单位1:日2:月
     */
    private Byte borrowPeriodUnit;
    /**
     * 产品UV统计
     */
    private int staticUV;
    /**
     * 最小借款周期
     */
    private Integer minBorrowPeriod;
    /**
     * 最大借款周期
     */
    private Integer maxBorrowPeriod;
    /**
     * 产品周期
     */
    private String period;
}
