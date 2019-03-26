package com.gndc.core.model;

import com.gndc.common.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import tk.mybatis.mapper.annotation.LogicDelete;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@Table(name = "dc_product_data")
public class ProductData extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 产品id
     */
    private Integer productId;

    /**
     * 数据类型 1借款数据;2常见问题
     */
    private Byte dataType;

    /**
     * 借款金额
     */
    private BigDecimal borrowAmount;

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

    /**
     * 日利率
     */
    private BigDecimal dayRate;

    /**
     * 问题标题
     */
    private String questionTitle;

    /**
     * 回答内容
     */
    private String answer;

    /**
     * 状态  1存在；-1删除
     */
    @LogicDelete(notDeletedValue = 1, isDeletedValue = 0)
    private Byte status;

}