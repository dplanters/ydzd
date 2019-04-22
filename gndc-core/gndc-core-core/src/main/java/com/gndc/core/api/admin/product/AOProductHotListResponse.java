package com.gndc.core.api.admin.product;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class AOProductHotListResponse implements Serializable {

    private Integer id;

    /**
     * 产品名称
     */
    private String name;

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
     * 最近热推时间
     */
    private Date onlineTime;


    /**
     * 热推状态
     */
    private Byte hotStatus;

    /**
     * 排序
     */
    private Byte position;

}
