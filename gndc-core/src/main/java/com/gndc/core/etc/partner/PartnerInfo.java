package com.gndc.core.etc.partner;

import com.gndc.core.model.Partner;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PartnerInfo extends Partner {

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
