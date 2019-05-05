package com.gndc.common.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@Accessors(chain = true)
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
     * 机构应用ID
     */
    private String appId;

    /**
     * 机构公钥
     */
    private String publicKey;

    /**
     * 状态：1 正常； -1删除
     */
    private Byte status;

}