package com.gndc.core.api.admin.product;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class AOProductAddRequest extends RequestMessage {

    /**
     * 商户id
     */
    @NotNull
    @Min(1)
    private Integer partnerId;

    /**
     * 产品名称
     */
    @NotNull
    @NotBlank
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
    @NotBlank
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
    private AOProductDataRequest extra;

}
