package com.gndc.core.model;

import com.gndc.common.model.BaseEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "dc_partner")
public class Partner extends BaseEntity {
    /**
     *
     */
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
     * 机构名称
     *
     * @return name 机构名称
     */
    public String getName() {
        return name;
    }

    /**
     * 机构名称
     *
     * @param name 机构名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 账户余额
     *
     * @return account_balance 账户余额
     */
    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    /**
     * 账户余额
     *
     * @param accountBalance 账户余额
     */
    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    /**
     * 授信额度
     *
     * @return auth_amount 授信额度
     */
    public BigDecimal getAuthAmount() {
        return authAmount;
    }

    /**
     * 授信额度
     *
     * @param authAmount 授信额度
     */
    public void setAuthAmount(BigDecimal authAmount) {
        this.authAmount = authAmount;
    }

    /**
     * 已用授信余额
     *
     * @return auth_balance_used 已用授信余额
     */
    public BigDecimal getAuthBalanceUsed() {
        return authBalanceUsed;
    }

    /**
     * 已用授信余额
     *
     * @param authBalanceUsed 已用授信余额
     */
    public void setAuthBalanceUsed(BigDecimal authBalanceUsed) {
        this.authBalanceUsed = authBalanceUsed;
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
     * @mbggenerated 2019-02-25
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
        Partner other = (Partner) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getAccountBalance() == null ? other.getAccountBalance() == null : this.getAccountBalance().equals(other.getAccountBalance()))
                && (this.getAuthAmount() == null ? other.getAuthAmount() == null : this.getAuthAmount().equals(other.getAuthAmount()))
                && (this.getAuthBalanceUsed() == null ? other.getAuthBalanceUsed() == null : this.getAuthBalanceUsed().equals(other.getAuthBalanceUsed()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    /**
     * @mbggenerated 2019-02-25
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAccountBalance() == null) ? 0 : getAccountBalance().hashCode());
        result = prime * result + ((getAuthAmount() == null) ? 0 : getAuthAmount().hashCode());
        result = prime * result + ((getAuthBalanceUsed() == null) ? 0 : getAuthBalanceUsed().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    /**
     * @mbggenerated 2019-02-25
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", accountBalance=").append(accountBalance);
        sb.append(", authAmount=").append(authAmount);
        sb.append(", authBalanceUsed=").append(authBalanceUsed);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}