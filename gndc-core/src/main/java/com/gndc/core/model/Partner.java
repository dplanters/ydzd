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
@Table(name = "dc_partner")
public class Partner extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 机构名称
     */
    private String name;

    /**
     * 账户余额
     */
    private BigDecimal accountBalance;

    /**
     * 授信额度
     */
    private BigDecimal authAmount;

    /**
     * 已用授信余额
     */
    private BigDecimal authBalanceUsed;

    /**
     * 状态：1 正常； -1删除
     */
    @LogicDelete(isDeletedValue = 0, notDeletedValue = 1)
    private Byte status;

}