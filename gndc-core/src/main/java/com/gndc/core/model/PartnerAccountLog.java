package com.gndc.core.model;


import com.gndc.common.model.BaseEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "dc_partner_account_log")
public class PartnerAccountLog extends BaseEntity {
    /**
     *
     */
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

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 合作机构ID
     *
     * @return partner_id 合作机构ID
     */
    public Integer getPartnerId() {
        return partnerId;
    }

    /**
     * 合作机构ID
     *
     * @param partnerId 合作机构ID
     */
    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    /**
     * 金额
     *
     * @return amount 金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 金额
     *
     * @param amount 金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 1充值 2提现
     *
     * @return type 1充值 2提现
     */
    public Byte getType() {
        return type;
    }

    /**
     * 1充值 2提现
     *
     * @param type 1充值 2提现
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 充值方式
     *
     * @return recharge_method 充值方式
     */
    public Byte getRechargeMethod() {
        return rechargeMethod;
    }

    /**
     * 充值方式
     *
     * @param rechargeMethod 充值方式
     */
    public void setRechargeMethod(Byte rechargeMethod) {
        this.rechargeMethod = rechargeMethod;
    }

    /**
     * 支付凭证
     *
     * @return pay_voucher 支付凭证
     */
    public String getPayVoucher() {
        return payVoucher;
    }

    /**
     * 支付凭证
     *
     * @param payVoucher 支付凭证
     */
    public void setPayVoucher(String payVoucher) {
        this.payVoucher = payVoucher;
    }

    /**
     * 充值日期
     *
     * @return pay_date 充值日期
     */
    public Date getPayDate() {
        return payDate;
    }

    /**
     * 充值日期
     *
     * @param payDate 充值日期
     */
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    /**
     * 打款人/公司
     *
     * @return payer 打款人/公司
     */
    public String getPayer() {
        return payer;
    }

    /**
     * 打款人/公司
     *
     * @param payer 打款人/公司
     */
    public void setPayer(String payer) {
        this.payer = payer;
    }

    /**
     * 收款人/公司
     *
     * @return payee 收款人/公司
     */
    public String getPayee() {
        return payee;
    }

    /**
     * 收款人/公司
     *
     * @param payee 收款人/公司
     */
    public void setPayee(String payee) {
        this.payee = payee;
    }

    /**
     * 收款人开户行
     *
     * @return payee_bank 收款人开户行
     */
    public String getPayeeBank() {
        return payeeBank;
    }

    /**
     * 收款人开户行
     *
     * @param payeeBank 收款人开户行
     */
    public void setPayeeBank(String payeeBank) {
        this.payeeBank = payeeBank;
    }

    /**
     * 收款人银行账号
     *
     * @return payee_bank_account 收款人银行账号
     */
    public String getPayeeBankAccount() {
        return payeeBankAccount;
    }

    /**
     * 收款人银行账号
     *
     * @param payeeBankAccount 收款人银行账号
     */
    public void setPayeeBankAccount(String payeeBankAccount) {
        this.payeeBankAccount = payeeBankAccount;
    }

    /**
     * 1 充值中 2充值成功 3提现中 4提现成功
     *
     * @return pay_status 1 充值中 2充值成功 3提现中 4提现成功
     */
    public Byte getPayStatus() {
        return payStatus;
    }

    /**
     * 1 充值中 2充值成功 3提现中 4提现成功
     *
     * @param payStatus 1 充值中 2充值成功 3提现中 4提现成功
     */
    public void setPayStatus(Byte payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * 备注
     *
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 操作人ID
     *
     * @return operator_id 操作人ID
     */
    public Integer getOperatorId() {
        return operatorId;
    }

    /**
     * 操作人ID
     *
     * @param operatorId 操作人ID
     */
    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * 状态：1 正常； -1删除
     *
     * @return status 状态：1 正常； -1删除
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 状态：1 正常； -1删除
     *
     * @param status 状态：1 正常； -1删除
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * @mbggenerated 2019-02-26
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PartnerAccountLog other = (PartnerAccountLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
                && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
                && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
                && (this.getRechargeMethod() == null ? other.getRechargeMethod() == null : this.getRechargeMethod().equals(other.getRechargeMethod()))
                && (this.getPayVoucher() == null ? other.getPayVoucher() == null : this.getPayVoucher().equals(other.getPayVoucher()))
                && (this.getPayDate() == null ? other.getPayDate() == null : this.getPayDate().equals(other.getPayDate()))
                && (this.getPayer() == null ? other.getPayer() == null : this.getPayer().equals(other.getPayer()))
                && (this.getPayee() == null ? other.getPayee() == null : this.getPayee().equals(other.getPayee()))
                && (this.getPayeeBank() == null ? other.getPayeeBank() == null : this.getPayeeBank().equals(other.getPayeeBank()))
                && (this.getPayeeBankAccount() == null ? other.getPayeeBankAccount() == null : this.getPayeeBankAccount().equals(other.getPayeeBankAccount()))
                && (this.getPayStatus() == null ? other.getPayStatus() == null : this.getPayStatus().equals(other.getPayStatus()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
                && (this.getOperatorId() == null ? other.getOperatorId() == null : this.getOperatorId().equals(other.getOperatorId()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    /**
     * @mbggenerated 2019-02-26
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getRechargeMethod() == null) ? 0 : getRechargeMethod().hashCode());
        result = prime * result + ((getPayVoucher() == null) ? 0 : getPayVoucher().hashCode());
        result = prime * result + ((getPayDate() == null) ? 0 : getPayDate().hashCode());
        result = prime * result + ((getPayer() == null) ? 0 : getPayer().hashCode());
        result = prime * result + ((getPayee() == null) ? 0 : getPayee().hashCode());
        result = prime * result + ((getPayeeBank() == null) ? 0 : getPayeeBank().hashCode());
        result = prime * result + ((getPayeeBankAccount() == null) ? 0 : getPayeeBankAccount().hashCode());
        result = prime * result + ((getPayStatus() == null) ? 0 : getPayStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getOperatorId() == null) ? 0 : getOperatorId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    /**
     * @mbggenerated 2019-02-26
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", amount=").append(amount);
        sb.append(", type=").append(type);
        sb.append(", rechargeMethod=").append(rechargeMethod);
        sb.append(", payVoucher=").append(payVoucher);
        sb.append(", payDate=").append(payDate);
        sb.append(", payer=").append(payer);
        sb.append(", payee=").append(payee);
        sb.append(", payeeBank=").append(payeeBank);
        sb.append(", payeeBankAccount=").append(payeeBankAccount);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", remark=").append(remark);
        sb.append(", operatorId=").append(operatorId);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}