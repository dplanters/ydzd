package com.gndc.core.model;

import com.gndc.common.model.BaseEntity;
import tk.mybatis.mapper.annotation.LogicDelete;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "dc_product")
public class Product extends BaseEntity {
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
     * 产品名称
     */
    private String name;

    /**
     * 合作模式 1:CPI;2:CPA;3:CPL;4:CPS;5:CPC
     */
    private Byte coopeMode;

    /**
     * logo url
     */
    private String logoUrl;

    /**
     * 一句话描述产品
     */
    private String description;

    /**
     * 客服电话
     */
    private String custServPhone;

    /**
     * 申请条件
     */
    private String applyCondition;

    /**
     * 申请流程
     */
    private String applyProcess;

    /**
     * 还款说明
     */
    private String repayInfo;

    /**
     * 位置
     */
    private Byte position;

    /**
     * 最新上线时间
     */
    private Date onlineTime;

    /**
     * 最后下线时间
     */
    private Date offlineTime;

    /**
     * 排序方式 1不固定排序；-1固定排序
     */
    private Byte sortType;

    /**
     * 固定排序位置
     */
    private Integer fixedSortType;

    /**
     * 状态  1未上线;2上线;-1下线
     */
    private Byte status;

    /**
     * 状态  1存在；-1删除
     */
    private Byte isDel;

    /**
     * 产品Android手机跳转地址
     */
    private String androidLink;

    /**
     * 产品iOS手机跳转地址
     */
    private String iosLink;

    /**
     * 借贷金额开始
     */
    private BigDecimal borrowAmountBegin;

    /**
     * 借贷金额结束
     */
    private BigDecimal borrowAmountEnd;

    /**
     * 是否展示详情
     */
    private Byte isDetail;

    /**
     * 日利率
     */
    private BigDecimal dayRate;

    /**
     * 合作价格
     */
    private BigDecimal coopePrice;

    /**
     * 标签1:审批快，多个";"隔开
     */
    private String tags;

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
     * 产品名称
     *
     * @return name 产品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 产品名称
     *
     * @param name 产品名称
     */
    public void setName(String name) {
        this.name = name;
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
     * logo url
     *
     * @return logo_url logo url
     */
    public String getLogoUrl() {
        return logoUrl;
    }

    /**
     * logo url
     *
     * @param logoUrl logo url
     */
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    /**
     * 一句话描述产品
     *
     * @return description 一句话描述产品
     */
    public String getDescription() {
        return description;
    }

    /**
     * 一句话描述产品
     *
     * @param description 一句话描述产品
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 客服电话
     *
     * @return cust_serv_phone 客服电话
     */
    public String getCustServPhone() {
        return custServPhone;
    }

    /**
     * 客服电话
     *
     * @param custServPhone 客服电话
     */
    public void setCustServPhone(String custServPhone) {
        this.custServPhone = custServPhone;
    }

    /**
     * 申请条件
     *
     * @return apply_condition 申请条件
     */
    public String getApplyCondition() {
        return applyCondition;
    }

    /**
     * 申请条件
     *
     * @param applyCondition 申请条件
     */
    public void setApplyCondition(String applyCondition) {
        this.applyCondition = applyCondition;
    }

    /**
     * 申请流程
     *
     * @return apply_process 申请流程
     */
    public String getApplyProcess() {
        return applyProcess;
    }

    /**
     * 申请流程
     *
     * @param applyProcess 申请流程
     */
    public void setApplyProcess(String applyProcess) {
        this.applyProcess = applyProcess;
    }

    /**
     * 还款说明
     *
     * @return repay_info 还款说明
     */
    public String getRepayInfo() {
        return repayInfo;
    }

    /**
     * 还款说明
     *
     * @param repayInfo 还款说明
     */
    public void setRepayInfo(String repayInfo) {
        this.repayInfo = repayInfo;
    }

    /**
     * 位置
     *
     * @return position 位置
     */
    public Byte getPosition() {
        return position;
    }

    /**
     * 位置
     *
     * @param position 位置
     */
    public void setPosition(Byte position) {
        this.position = position;
    }

    /**
     * 最新上线时间
     *
     * @return online_time 最新上线时间
     */
    public Date getOnlineTime() {
        return onlineTime;
    }

    /**
     * 最新上线时间
     *
     * @param onlineTime 最新上线时间
     */
    public void setOnlineTime(Date onlineTime) {
        this.onlineTime = onlineTime;
    }

    /**
     * 最后下线时间
     *
     * @return offline_time 最后下线时间
     */
    public Date getOfflineTime() {
        return offlineTime;
    }

    /**
     * 最后下线时间
     *
     * @param offlineTime 最后下线时间
     */
    public void setOfflineTime(Date offlineTime) {
        this.offlineTime = offlineTime;
    }

    /**
     * 排序方式 1不固定排序；-1固定排序
     *
     * @return sort_type 排序方式 1不固定排序；-1固定排序
     */
    public Byte getSortType() {
        return sortType;
    }

    /**
     * 排序方式 1不固定排序；-1固定排序
     *
     * @param sortType 排序方式 1不固定排序；-1固定排序
     */
    public void setSortType(Byte sortType) {
        this.sortType = sortType;
    }

    /**
     * 固定排序位置
     *
     * @return fixed_sort_type 固定排序位置
     */
    public Integer getFixedSortType() {
        return fixedSortType;
    }

    /**
     * 固定排序位置
     *
     * @param fixedSortType 固定排序位置
     */
    public void setFixedSortType(Integer fixedSortType) {
        this.fixedSortType = fixedSortType;
    }

    /**
     * 状态  1未上线;2上线;-1下线
     *
     * @return status 状态  1未上线;2上线;-1下线
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 状态  1未上线;2上线;-1下线
     *
     * @param status 状态  1未上线;2上线;-1下线
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 状态  1存在；-1删除
     *
     * @return is_del 状态  1存在；-1删除
     */
    public Byte getIsDel() {
        return isDel;
    }

    /**
     * 状态  1存在；-1删除
     *
     * @param isDel 状态  1存在；-1删除
     */
    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }

    /**
     * 产品Android手机跳转地址
     *
     * @return android_link 产品Android手机跳转地址
     */
    public String getAndroidLink() {
        return androidLink;
    }

    /**
     * 产品Android手机跳转地址
     *
     * @param androidLink 产品Android手机跳转地址
     */
    public void setAndroidLink(String androidLink) {
        this.androidLink = androidLink;
    }

    /**
     * 产品iOS手机跳转地址
     *
     * @return ios_link 产品iOS手机跳转地址
     */
    public String getIosLink() {
        return iosLink;
    }

    /**
     * 产品iOS手机跳转地址
     *
     * @param iosLink 产品iOS手机跳转地址
     */
    public void setIosLink(String iosLink) {
        this.iosLink = iosLink;
    }

    /**
     * 借贷金额开始
     *
     * @return borrow_amount_begin 借贷金额开始
     */
    public BigDecimal getBorrowAmountBegin() {
        return borrowAmountBegin;
    }

    /**
     * 借贷金额开始
     *
     * @param borrowAmountBegin 借贷金额开始
     */
    public void setBorrowAmountBegin(BigDecimal borrowAmountBegin) {
        this.borrowAmountBegin = borrowAmountBegin;
    }

    /**
     * 借贷金额结束
     *
     * @return borrow_amount_end 借贷金额结束
     */
    public BigDecimal getBorrowAmountEnd() {
        return borrowAmountEnd;
    }

    /**
     * 借贷金额结束
     *
     * @param borrowAmountEnd 借贷金额结束
     */
    public void setBorrowAmountEnd(BigDecimal borrowAmountEnd) {
        this.borrowAmountEnd = borrowAmountEnd;
    }

    /**
     * 是否展示详情
     *
     * @return is_detail 是否展示详情
     */
    public Byte getIsDetail() {
        return isDetail;
    }

    /**
     * 是否展示详情
     *
     * @param isDetail 是否展示详情
     */
    public void setIsDetail(Byte isDetail) {
        this.isDetail = isDetail;
    }

    /**
     * 日利率
     *
     * @return day_rate 日利率
     */
    public BigDecimal getDayRate() {
        return dayRate;
    }

    /**
     * 日利率
     *
     * @param dayRate 日利率
     */
    public void setDayRate(BigDecimal dayRate) {
        this.dayRate = dayRate;
    }

    /**
     * 合作价格
     *
     * @return coope_price 合作价格
     */
    public BigDecimal getCoopePrice() {
        return coopePrice;
    }

    /**
     * 合作价格
     *
     * @param coopePrice 合作价格
     */
    public void setCoopePrice(BigDecimal coopePrice) {
        this.coopePrice = coopePrice;
    }

    /**
     * 标签1:审批快，多个";"隔开
     *
     * @return tags 标签1:审批快，多个";"隔开
     */
    public String getTags() {
        return tags;
    }

    /**
     * 标签1:审批快，多个";"隔开
     *
     * @param tags 标签1:审批快，多个";"隔开
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     * @mbggenerated 2019-03-05
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
        Product other = (Product) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getPartnerId() == null ? other.getPartnerId() == null : this.getPartnerId().equals(other.getPartnerId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getCoopeMode() == null ? other.getCoopeMode() == null : this.getCoopeMode().equals(other.getCoopeMode()))
                && (this.getLogoUrl() == null ? other.getLogoUrl() == null : this.getLogoUrl().equals(other.getLogoUrl()))
                && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
                && (this.getCustServPhone() == null ? other.getCustServPhone() == null : this.getCustServPhone().equals(other.getCustServPhone()))
                && (this.getApplyCondition() == null ? other.getApplyCondition() == null : this.getApplyCondition().equals(other.getApplyCondition()))
                && (this.getApplyProcess() == null ? other.getApplyProcess() == null : this.getApplyProcess().equals(other.getApplyProcess()))
                && (this.getRepayInfo() == null ? other.getRepayInfo() == null : this.getRepayInfo().equals(other.getRepayInfo()))
                && (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition()))
                && (this.getOnlineTime() == null ? other.getOnlineTime() == null : this.getOnlineTime().equals(other.getOnlineTime()))
                && (this.getOfflineTime() == null ? other.getOfflineTime() == null : this.getOfflineTime().equals(other.getOfflineTime()))
                && (this.getSortType() == null ? other.getSortType() == null : this.getSortType().equals(other.getSortType()))
                && (this.getFixedSortType() == null ? other.getFixedSortType() == null : this.getFixedSortType().equals(other.getFixedSortType()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()))
                && (this.getAndroidLink() == null ? other.getAndroidLink() == null : this.getAndroidLink().equals(other.getAndroidLink()))
                && (this.getIosLink() == null ? other.getIosLink() == null : this.getIosLink().equals(other.getIosLink()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getBorrowAmountBegin() == null ? other.getBorrowAmountBegin() == null : this.getBorrowAmountBegin().equals(other.getBorrowAmountBegin()))
                && (this.getBorrowAmountEnd() == null ? other.getBorrowAmountEnd() == null : this.getBorrowAmountEnd().equals(other.getBorrowAmountEnd()))
                && (this.getIsDetail() == null ? other.getIsDetail() == null : this.getIsDetail().equals(other.getIsDetail()))
                && (this.getDayRate() == null ? other.getDayRate() == null : this.getDayRate().equals(other.getDayRate()))
                && (this.getCoopePrice() == null ? other.getCoopePrice() == null : this.getCoopePrice().equals(other.getCoopePrice()))
                && (this.getTags() == null ? other.getTags() == null : this.getTags().equals(other.getTags()));
    }

    /**
     * @mbggenerated 2019-03-05
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPartnerId() == null) ? 0 : getPartnerId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCoopeMode() == null) ? 0 : getCoopeMode().hashCode());
        result = prime * result + ((getLogoUrl() == null) ? 0 : getLogoUrl().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCustServPhone() == null) ? 0 : getCustServPhone().hashCode());
        result = prime * result + ((getApplyCondition() == null) ? 0 : getApplyCondition().hashCode());
        result = prime * result + ((getApplyProcess() == null) ? 0 : getApplyProcess().hashCode());
        result = prime * result + ((getRepayInfo() == null) ? 0 : getRepayInfo().hashCode());
        result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
        result = prime * result + ((getOnlineTime() == null) ? 0 : getOnlineTime().hashCode());
        result = prime * result + ((getOfflineTime() == null) ? 0 : getOfflineTime().hashCode());
        result = prime * result + ((getSortType() == null) ? 0 : getSortType().hashCode());
        result = prime * result + ((getFixedSortType() == null) ? 0 : getFixedSortType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        result = prime * result + ((getAndroidLink() == null) ? 0 : getAndroidLink().hashCode());
        result = prime * result + ((getIosLink() == null) ? 0 : getIosLink().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getBorrowAmountBegin() == null) ? 0 : getBorrowAmountBegin().hashCode());
        result = prime * result + ((getBorrowAmountEnd() == null) ? 0 : getBorrowAmountEnd().hashCode());
        result = prime * result + ((getIsDetail() == null) ? 0 : getIsDetail().hashCode());
        result = prime * result + ((getDayRate() == null) ? 0 : getDayRate().hashCode());
        result = prime * result + ((getCoopePrice() == null) ? 0 : getCoopePrice().hashCode());
        result = prime * result + ((getTags() == null) ? 0 : getTags().hashCode());
        return result;
    }

    /**
     * @mbggenerated 2019-03-05
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", name=").append(name);
        sb.append(", coopeMode=").append(coopeMode);
        sb.append(", logoUrl=").append(logoUrl);
        sb.append(", description=").append(description);
        sb.append(", custServPhone=").append(custServPhone);
        sb.append(", applyCondition=").append(applyCondition);
        sb.append(", applyProcess=").append(applyProcess);
        sb.append(", repayInfo=").append(repayInfo);
        sb.append(", position=").append(position);
        sb.append(", onlineTime=").append(onlineTime);
        sb.append(", offlineTime=").append(offlineTime);
        sb.append(", sortType=").append(sortType);
        sb.append(", fixedSortType=").append(fixedSortType);
        sb.append(", status=").append(status);
        sb.append(", isDel=").append(isDel);
        sb.append(", androidLink=").append(androidLink);
        sb.append(", iosLink=").append(iosLink);
        sb.append(", borrowAmountBegin=").append(borrowAmountBegin);
        sb.append(", borrowAmountEnd=").append(borrowAmountEnd);
        sb.append(", isDetail=").append(isDetail);
        sb.append(", dayRate=").append(dayRate);
        sb.append(", coopePrice=").append(coopePrice);
        sb.append(", tags=").append(tags);
        sb.append("]");
        return sb.toString();
    }
}