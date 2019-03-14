package com.gndc.core.api.admin.product;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class AOProductDetailResponse extends RequestMessage {

    /**
     * 产品id
     */
    private Integer id;

    /**
     * 商户id
     */
    @NotNull
    private Integer partnerId;

    /**
     * 产品名称
     */
    @NotNull
    private String name;

    /**
     * 合作模式
     */
    @NotNull
    private Byte coopeMode;

    private String logoUrl;

    /**
     * 产品描述
     */
    @NotNull
    private String description;

    /**
     * 合作价格
     */
    private BigDecimal coopePrice;

    /**
     * 标签1:审批快，多个";"隔开
     */
    private String tags;

    /**
     * 产品链接
     */
    private String productLink;

    /**
     * 可贷金额开始
     */
    private BigDecimal borrowAmountBegin;
    /**
     * 可贷金额结束
     */
    private BigDecimal borrowAmountEnd;

    /**
     * 产品附加信息
     */
    private AOProductDataDetailResponse extra;

}
