package com.gndc.core.api.app.product.hot;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class PHotProductResponse implements Serializable {


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
}
