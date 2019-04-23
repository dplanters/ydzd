package com.gndc.core.api.partner.product;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class APProductListResponse implements Serializable {

    private Integer id;

    /**
     * 合作机构ID
     */
    private Integer partnerId;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 一句话描述产品
     */
    private String description;

    /**
     * 借贷金额开始
     */
    private BigDecimal borrowAmountBegin;

    /**
     * 借贷金额结束
     */
    private BigDecimal borrowAmountEnd;

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

}
