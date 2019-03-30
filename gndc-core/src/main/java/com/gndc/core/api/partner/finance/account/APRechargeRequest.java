package com.gndc.core.api.partner.finance.account;

import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class APRechargeRequest extends RequestMessage {

    /**
     * 充值方式
     */
    private Byte rechargeMethod;
    /**
     * 金额
     */
    private BigDecimal amount;
    /**
     * 打款人/公司
     */
    private String payer;
    /**
     * 收款人/公司
     */
    private String payee;
    /**
     * 打款时间
     */
    private Date payDate;
    /**
     * 备注
     */
    private String remark;
    /**
     * 支付凭证
     */
    private String payVoucher;

}
