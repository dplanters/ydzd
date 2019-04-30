package com.gndc.common.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Table(name = "dc_partner_account_log")
public class PartnerAccountLog extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 合作机构ID
     */
    private Integer partnerId;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 1充值 2提现
     */
    private Byte type;

    /**
     * 充值方式
     */
    private Byte rechargeMethod;

    /**
     * 支付凭证
     */
    private String payVoucher;

    /**
     * 充值日期
     */
    private Date payDate;

    /**
     * 打款人/公司
     */
    private String payer;

    /**
     * 收款人/公司
     */
    private String payee;

    /**
     * 收款人开户行
     */
    private String payeeBank;

    /**
     * 收款人银行账号
     */
    private String payeeBankAccount;

    /**
     * 1 充值中 2充值成功 3提现中 4提现成功
     */
    private Byte payStatus;

    /**
     * 备注
     */
    private String remark;

    /**
     * 操作人ID
     */
    private Integer operatorId;

    /**
     * 状态：1 正常； -1删除
     */
    private Byte status;

}