package com.gndc.core.api.partner.finance.account;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class APPartnerInfoResponse implements Serializable {

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
     * 剩余授信额度
     */
    private BigDecimal authBalance;

    /**
     * 充值中金额
     */
    private BigDecimal processingRechargeAmount;

    /**
     * 提现中金额
     */
    private BigDecimal processingWithDrawAmount;

}
