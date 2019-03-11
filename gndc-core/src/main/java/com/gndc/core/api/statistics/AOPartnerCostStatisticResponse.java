package com.gndc.core.api.statistics;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author jingkaihui
 * @date 2019/3/6
 */
@Getter
@Setter
public class AOPartnerCostStatisticResponse implements Serializable {

    /**
     * 机构id
     */
    private Integer id;

    /**
     * 商户名
     */
    private String name;

    /**
     * 产品数
     */
    private Long count;

    /**
     * 费用统计
     */
    private BigDecimal cost;

}
