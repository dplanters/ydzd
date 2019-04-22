package com.gndc.core.api.partner.finance.account;

import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class APWithdrawRequest extends RequestMessage {

    private static final long serialVersionUID = 1L;
    /**
     * 收款人银行账号
     */
    private String payeeBankAccount;
    /**
     * 收款人开户行
     */
    private String payeeBank;
    /**
     * 收款人/公司
     */
    private String payee;
    /**
     * 金额
     */
    private BigDecimal amount;
    /**
     * 备注
     */
    private String remark;

}
