package com.gndc.core.model;

import com.gndc.common.model.BaseEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
@Table(name = "dc_event_fee")
public class EventFee extends BaseEntity {
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 事件ID
     */
    private Integer eventId;

    /**
     * 产品id
     */
    private Integer productId;

    /**
     * 合作机构ID
     */
    private Integer partnerId;

    /**
     * 费用金额
     */
    private BigDecimal fee;

    /**
     * 费用分类：1-h5 2-Api
     */
    private Byte feeType;

    /**
     * 合作模式 1:CPI;2:CPA;3:CPL;4:CPS;5:CPC
     */
    private Byte coopeMode;

    /**
     * 事件类型 1热推点击；2列表点击；3点击下载；4收藏；5取消收藏；6打开app;7 登录;8产品点击
     */
    private Byte eventType;

    /**
     * 费用状态 0-未结算 1-已结算
     */
    private Byte feeStatus;

    /**
     * 是否删除  1正常;-1删除
     */
    private Byte status;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 事件ID
     *
     * @return event_id 事件ID
     */
    public Integer getEventId() {
        return eventId;
    }

    /**
     * 事件ID
     *
     * @param eventId 事件ID
     */
    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    /**
     * 产品id
     *
     * @return product_id 产品id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 产品id
     *
     * @param productId 产品id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
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
     * 费用金额
     *
     * @return fee 费用金额
     */
    public BigDecimal getFee() {
        return fee;
    }

    /**
     * 费用金额
     *
     * @param fee 费用金额
     */
    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    /**
     * 费用分类：1-h5 2-Api
     *
     * @return fee_type 费用分类：1-h5 2-Api
     */
    public Byte getFeeType() {
        return feeType;
    }

    /**
     * 费用分类：1-h5 2-Api
     *
     * @param feeType 费用分类：1-h5 2-Api
     */
    public void setFeeType(Byte feeType) {
        this.feeType = feeType;
    }

    /**
     * 合作模式 1:CPI;2:CPA;3:CPL;4:CPS;5:CPC
     *
     * @return coope_mode 合作模式 1:CPI;2:CPA;3:CPL;4:CPS;5:CPC
     */
    public Byte getCoopeMode() {
        return coopeMode;
    }

    /**
     * 合作模式 1:CPI;2:CPA;3:CPL;4:CPS;5:CPC
     *
     * @param coopeMode 合作模式 1:CPI;2:CPA;3:CPL;4:CPS;5:CPC
     */
    public void setCoopeMode(Byte coopeMode) {
        this.coopeMode = coopeMode;
    }

    /**
     * 事件类型 1热推点击；2列表点击；3点击下载；4收藏；5取消收藏；6打开app;7 登录;8产品点击
     *
     * @return event_type 事件类型 1热推点击；2列表点击；3点击下载；4收藏；5取消收藏；6打开app;7 登录;8产品点击
     */
    public Byte getEventType() {
        return eventType;
    }

    /**
     * 事件类型 1热推点击；2列表点击；3点击下载；4收藏；5取消收藏；6打开app;7 登录;8产品点击
     *
     * @param eventType 事件类型 1热推点击；2列表点击；3点击下载；4收藏；5取消收藏；6打开app;7 登录;8产品点击
     */
    public void setEventType(Byte eventType) {
        this.eventType = eventType;
    }

    /**
     * 费用状态 0-未结算 1-已结算
     *
     * @return fee_status 费用状态 0-未结算 1-已结算
     */
    public Byte getFeeStatus() {
        return feeStatus;
    }

    /**
     * 费用状态 0-未结算 1-已结算
     *
     * @param feeStatus 费用状态 0-未结算 1-已结算
     */
    public void setFeeStatus(Byte feeStatus) {
        this.feeStatus = feeStatus;
    }

    /**
     * 是否删除  1正常;-1删除
     *
     * @return status 是否删除  1正常;-1删除
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 是否删除  1正常;-1删除
     *
     * @param status 是否删除  1正常;-1删除
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * @mbggenerated 2019-03-01
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
        EventFee other = (EventFee) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getEventId() == null ? other.getEventId() == null : this.getEventId().equals(other.getEventId()))
                && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
                && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
                && (this.getFee() == null ? other.getFee() == null : this.getFee().equals(other.getFee()))
                && (this.getFeeType() == null ? other.getFeeType() == null : this.getFeeType().equals(other.getFeeType()))
                && (this.getCoopeMode() == null ? other.getCoopeMode() == null : this.getCoopeMode().equals(other.getCoopeMode()))
                && (this.getEventType() == null ? other.getEventType() == null : this.getEventType().equals(other.getEventType()))
                && (this.getFeeStatus() == null ? other.getFeeStatus() == null : this.getFeeStatus().equals(other.getFeeStatus()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    /**
     * @mbggenerated 2019-03-01
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEventId() == null) ? 0 : getEventId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getFee() == null) ? 0 : getFee().hashCode());
        result = prime * result + ((getFeeType() == null) ? 0 : getFeeType().hashCode());
        result = prime * result + ((getCoopeMode() == null) ? 0 : getCoopeMode().hashCode());
        result = prime * result + ((getEventType() == null) ? 0 : getEventType().hashCode());
        result = prime * result + ((getFeeStatus() == null) ? 0 : getFeeStatus().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    /**
     * @mbggenerated 2019-03-01
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", eventId=").append(eventId);
        sb.append(", productId=").append(productId);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", fee=").append(fee);
        sb.append(", feeType=").append(feeType);
        sb.append(", coopeMode=").append(coopeMode);
        sb.append(", eventType=").append(eventType);
        sb.append(", feeStatus=").append(feeStatus);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}