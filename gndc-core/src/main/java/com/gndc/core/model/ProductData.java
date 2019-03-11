package com.gndc.core.model;

import com.gndc.common.model.BaseEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "dc_product_data")
public class ProductData extends BaseEntity {
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 产品id
     */
    private Integer productId;

    /**
     * 数据类型 1借款数据;2常见问题
     */
    private Byte dataType;

    /**
     * 借款金额
     */
    private BigDecimal borrowAmount;

    /**
     * 借款周期开始
     */
    private Integer borrowPeriodStart;

    /**
     * 借款周期结束
     */
    private Integer borrowPeriodEnd;

    /**
     * 1:日2:月
     */
    private Byte borrowPeriodUnit;

    /**
     * 放款时间描述
     */
    private String borrowTimeDescription;

    /**
     * 日利率
     */
    private BigDecimal dayRate;

    /**
     * 问题标题
     */
    private String questionTitle;

    /**
     * 回答内容
     */
    private String answer;

    /**
     * 状态  1存在；-1删除
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
     * 数据类型 1借款数据;2常见问题
     *
     * @return data_type 数据类型 1借款数据;2常见问题
     */
    public Byte getDataType() {
        return dataType;
    }

    /**
     * 数据类型 1借款数据;2常见问题
     *
     * @param dataType 数据类型 1借款数据;2常见问题
     */
    public void setDataType(Byte dataType) {
        this.dataType = dataType;
    }

    /**
     * 借款金额
     *
     * @return borrow_amount 借款金额
     */
    public BigDecimal getBorrowAmount() {
        return borrowAmount;
    }

    /**
     * 借款金额
     *
     * @param borrowAmount 借款金额
     */
    public void setBorrowAmount(BigDecimal borrowAmount) {
        this.borrowAmount = borrowAmount;
    }

    /**
     * 借款周期开始
     *
     * @return borrow_period_start 借款周期开始
     */
    public Integer getBorrowPeriodStart() {
        return borrowPeriodStart;
    }

    /**
     * 借款周期开始
     *
     * @param borrowPeriodStart 借款周期开始
     */
    public void setBorrowPeriodStart(Integer borrowPeriodStart) {
        this.borrowPeriodStart = borrowPeriodStart;
    }

    /**
     * 借款周期结束
     *
     * @return borrow_period_end 借款周期结束
     */
    public Integer getBorrowPeriodEnd() {
        return borrowPeriodEnd;
    }

    /**
     * 借款周期结束
     *
     * @param borrowPeriodEnd 借款周期结束
     */
    public void setBorrowPeriodEnd(Integer borrowPeriodEnd) {
        this.borrowPeriodEnd = borrowPeriodEnd;
    }

    /**
     * 1:日2:月
     *
     * @return borrow_period_unit 1:日2:月
     */
    public Byte getBorrowPeriodUnit() {
        return borrowPeriodUnit;
    }

    /**
     * 1:日2:月
     *
     * @param borrowPeriodUnit 1:日2:月
     */
    public void setBorrowPeriodUnit(Byte borrowPeriodUnit) {
        this.borrowPeriodUnit = borrowPeriodUnit;
    }

    /**
     * 放款时间描述
     *
     * @return borrow_time_description 放款时间描述
     */
    public String getBorrowTimeDescription() {
        return borrowTimeDescription;
    }

    /**
     * 放款时间描述
     *
     * @param borrowTimeDescription 放款时间描述
     */
    public void setBorrowTimeDescription(String borrowTimeDescription) {
        this.borrowTimeDescription = borrowTimeDescription;
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
     * 问题标题
     *
     * @return question_title 问题标题
     */
    public String getQuestionTitle() {
        return questionTitle;
    }

    /**
     * 问题标题
     *
     * @param questionTitle 问题标题
     */
    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    /**
     * 回答内容
     *
     * @return answer 回答内容
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * 回答内容
     *
     * @param answer 回答内容
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * 状态  1存在；-1删除
     *
     * @return status 状态  1存在；-1删除
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 状态  1存在；-1删除
     *
     * @param status 状态  1存在；-1删除
     */
    public void setStatus(Byte status) {
        this.status = status;
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
        ProductData other = (ProductData) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
                && (this.getDataType() == null ? other.getDataType() == null : this.getDataType().equals(other.getDataType()))
                && (this.getBorrowAmount() == null ? other.getBorrowAmount() == null : this.getBorrowAmount().equals(other.getBorrowAmount()))
                && (this.getBorrowPeriodStart() == null ? other.getBorrowPeriodStart() == null : this.getBorrowPeriodStart().equals(other.getBorrowPeriodStart()))
                && (this.getBorrowPeriodEnd() == null ? other.getBorrowPeriodEnd() == null : this.getBorrowPeriodEnd().equals(other.getBorrowPeriodEnd()))
                && (this.getBorrowPeriodUnit() == null ? other.getBorrowPeriodUnit() == null : this.getBorrowPeriodUnit().equals(other.getBorrowPeriodUnit()))
                && (this.getBorrowTimeDescription() == null ? other.getBorrowTimeDescription() == null : this.getBorrowTimeDescription().equals(other.getBorrowTimeDescription()))
                && (this.getDayRate() == null ? other.getDayRate() == null : this.getDayRate().equals(other.getDayRate()))
                && (this.getQuestionTitle() == null ? other.getQuestionTitle() == null : this.getQuestionTitle().equals(other.getQuestionTitle()))
                && (this.getAnswer() == null ? other.getAnswer() == null : this.getAnswer().equals(other.getAnswer()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    /**
     * @mbggenerated 2019-03-05
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getDataType() == null) ? 0 : getDataType().hashCode());
        result = prime * result + ((getBorrowAmount() == null) ? 0 : getBorrowAmount().hashCode());
        result = prime * result + ((getBorrowPeriodStart() == null) ? 0 : getBorrowPeriodStart().hashCode());
        result = prime * result + ((getBorrowPeriodEnd() == null) ? 0 : getBorrowPeriodEnd().hashCode());
        result = prime * result + ((getBorrowPeriodUnit() == null) ? 0 : getBorrowPeriodUnit().hashCode());
        result = prime * result + ((getBorrowTimeDescription() == null) ? 0 : getBorrowTimeDescription().hashCode());
        result = prime * result + ((getDayRate() == null) ? 0 : getDayRate().hashCode());
        result = prime * result + ((getQuestionTitle() == null) ? 0 : getQuestionTitle().hashCode());
        result = prime * result + ((getAnswer() == null) ? 0 : getAnswer().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
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
        sb.append(", productId=").append(productId);
        sb.append(", dataType=").append(dataType);
        sb.append(", borrowAmount=").append(borrowAmount);
        sb.append(", borrowPeriodStart=").append(borrowPeriodStart);
        sb.append(", borrowPeriodEnd=").append(borrowPeriodEnd);
        sb.append(", borrowPeriodUnit=").append(borrowPeriodUnit);
        sb.append(", borrowTimeDescription=").append(borrowTimeDescription);
        sb.append(", dayRate=").append(dayRate);
        sb.append(", questionTitle=").append(questionTitle);
        sb.append(", answer=").append(answer);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}