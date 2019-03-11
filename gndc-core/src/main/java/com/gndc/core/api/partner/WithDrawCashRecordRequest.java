package com.gndc.core.api.partner;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class WithDrawCashRecordRequest extends RequestMessage {

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

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.A_PARTNER_WITHDRAW_RECORD);
    }

}
