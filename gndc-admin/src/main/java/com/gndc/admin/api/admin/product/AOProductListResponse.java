package com.gndc.admin.api.admin.product;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class AOProductListResponse implements Serializable {

    private Integer id;

    private String logoUrl;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 借款金额范围
     */
    private String borrowAmountRange;

    /**
     * 借款时间范围
     */
    private String borrowTimeRange;

    /**
     * 合作机构名称
     */
    private String partnerName;

    /**
     * 合作模式
     */
    private Byte coopeMode;

    /**
     * 合作价格
     */
    private BigDecimal coopePrice;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 状态
     */
    private Byte productStatus;

    /**
     * 热推状态
     */
    private Byte hotStatus;

    /**
     * 一句话描述产品
     */
    private String description;

    /**
     * 放款时间描述
     */
    private String borrowTimeDescription;

    /**
     * 1:日2:月
     */
    private Byte borrowPeriodUnit;

    /**
     * 最新上线时间
     */
    private Date onlineTime;

    /**
     * 最后下线时间
     */
    private Date offlineTime;

}
