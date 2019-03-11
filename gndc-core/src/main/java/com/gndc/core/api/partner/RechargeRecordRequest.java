package com.gndc.core.api.partner;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class RechargeRecordRequest extends RequestMessage {

    private static final long serialVersionUID = 1L;
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

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.A_PARTNER_RECHARGE_RECORD);
    }

}
