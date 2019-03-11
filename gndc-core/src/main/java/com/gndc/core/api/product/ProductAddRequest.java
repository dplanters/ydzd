package com.gndc.core.api.product;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

import java.math.BigDecimal;
import java.util.List;

public class ProductAddRequest extends RequestMessage {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private Byte coopeMode;
    private String androidLink;
    private String iosLink;
    private String description;
    private String logoUrl;
    private String custServPhone;
    private String applyCondition;
    private String applyProcess;
    private String repayInfo;
    /**
     * 可贷金额开始
     */
    private BigDecimal borrowAmountBegin;
    /**
     * 可贷金额结束
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
    private List<ProductDataMoneyRequest> moneyDataList;
    private List<ProductDataQuestionRequest> questionDataList;
    private Byte sortType;
    private Integer fixedSortType;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.A_PRODUCT_ADD_MODIFY);
    }

    public Byte getSortType() {
        return sortType;
    }

    public void setSortType(Byte sortType) {
        this.sortType = sortType;
    }

    public Integer getFixedSortType() {
        return fixedSortType;
    }

    public void setFixedSortType(Integer fixedSortType) {
        this.fixedSortType = fixedSortType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getCoopeMode() {
        return coopeMode;
    }

    public void setCoopeMode(Byte coopeMode) {
        this.coopeMode = coopeMode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getCustServPhone() {
        return custServPhone;
    }

    public void setCustServPhone(String custServPhone) {
        this.custServPhone = custServPhone;
    }

    public String getApplyCondition() {
        return applyCondition;
    }

    public void setApplyCondition(String applyCondition) {
        this.applyCondition = applyCondition;
    }

    public String getApplyProcess() {
        return applyProcess;
    }

    public void setApplyProcess(String applyProcess) {
        this.applyProcess = applyProcess;
    }

    public String getRepayInfo() {
        return repayInfo;
    }

    public void setRepayInfo(String repayInfo) {
        this.repayInfo = repayInfo;
    }

    public List<ProductDataMoneyRequest> getMoneyDataList() {
        return moneyDataList;
    }

    public void setMoneyDataList(List<ProductDataMoneyRequest> moneyDataList) {
        this.moneyDataList = moneyDataList;
    }

    public List<ProductDataQuestionRequest> getQuestionDataList() {
        return questionDataList;
    }

    public void setQuestionDataList(List<ProductDataQuestionRequest> questionDataList) {
        this.questionDataList = questionDataList;
    }

    public String getAndroidLink() {
        return androidLink;
    }

    public void setAndroidLink(String androidLink) {
        this.androidLink = androidLink;
    }

    public String getIosLink() {
        return iosLink;
    }

    public void setIosLink(String iosLink) {
        this.iosLink = iosLink;
    }

    public BigDecimal getBorrowAmountBegin() {
        return borrowAmountBegin;
    }

    public void setBorrowAmountBegin(BigDecimal borrowAmountBegin) {
        this.borrowAmountBegin = borrowAmountBegin;
    }

    public BigDecimal getBorrowAmountEnd() {
        return borrowAmountEnd;
    }

    public void setBorrowAmountEnd(BigDecimal borrowAmountEnd) {
        this.borrowAmountEnd = borrowAmountEnd;
    }

    public Byte getIsDetail() {
        return isDetail;
    }

    public void setIsDetail(Byte isDetail) {
        this.isDetail = isDetail;
    }

    public BigDecimal getDayRate() {
        return dayRate;
    }

    public void setDayRate(BigDecimal dayRate) {
        this.dayRate = dayRate;
    }

}
