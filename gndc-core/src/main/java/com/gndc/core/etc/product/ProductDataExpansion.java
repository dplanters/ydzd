/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.etc.product;

import com.gndc.core.model.ProductData;

import java.math.BigDecimal;

/**
 * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
 * @version V1.0.1
 * @Description
 * @date 2018年8月16日 下午2:03:40
 */
public class ProductDataExpansion extends ProductData {

    private BigDecimal minBorrowAmount;

    private BigDecimal maxBorrowAmount;

    private String androidLink;

    private String iosLink;
    /**
     * 日利率
     */
    private BigDecimal dayRate;
    private String amountRange;
    private String periodRange;
    private String name;
    private String minDayRate;
    private Integer minBorrowPeriod;
    private Integer maxBorrowPeriod;
    /**
     * 1:日2:月
     */
    private Byte borrowPeriodUnit;
    /**
     * 放款时间描述
     */
    private String borrowTimeDescription;
    private String logoUrl;
    private String description;
    private Integer fixedSortType;
    private BigDecimal borrowAmountBegin;
    private BigDecimal borrowAmountEnd;
    /**
     * 是否添加产品详情
     */
    private Byte isDetail;
    /**
     * 产品UV统计
     */
    private int staticUV;
    /**
     * 产品周期
     */
    private String period;

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    @Override
    public String getBorrowTimeDescription() {
        return borrowTimeDescription;
    }

    @Override
    public void setBorrowTimeDescription(String borrowTimeDescription) {
        this.borrowTimeDescription = borrowTimeDescription;
    }

    @Override
    public Byte getBorrowPeriodUnit() {
        return borrowPeriodUnit;
    }

    @Override
    public void setBorrowPeriodUnit(Byte borrowPeriodUnit) {
        this.borrowPeriodUnit = borrowPeriodUnit;
    }

    public int getStaticUV() {
        return staticUV;
    }

    public void setStaticUV(int staticUV) {
        this.staticUV = staticUV;
    }

    /**
     * @return androidLink
     */
    public String getAndroidLink() {
        return androidLink;
    }

    /**
     * @param androidLink 要设置的 androidLink
     */
    public void setAndroidLink(String androidLink) {
        this.androidLink = androidLink;
    }

    /**
     * @return iosLink
     */
    public String getIosLink() {
        return iosLink;
    }

    /**
     * @param iosLink 要设置的 iosLink
     */
    public void setIosLink(String iosLink) {
        this.iosLink = iosLink;
    }

    /**
     * @return dayRate
     */
    public BigDecimal getDayRate() {
        return dayRate;
    }

    /**
     * @param dayRate 要设置的 dayRate
     */
    public void setDayRate(BigDecimal dayRate) {
        this.dayRate = dayRate;
    }

    /**
     * @return isDetail
     */
    public Byte getIsDetail() {
        return isDetail;
    }

    /**
     * @param isDetail 要设置的 isDetail
     */
    public void setIsDetail(Byte isDetail) {
        this.isDetail = isDetail;
    }

    /**
     * @return borrowAmountBegin
     */
    public BigDecimal getBorrowAmountBegin() {
        return borrowAmountBegin;
    }

    /**
     * @param borrowAmountBegin 要设置的 borrowAmountBegin
     */
    public void setBorrowAmountBegin(BigDecimal borrowAmountBegin) {
        this.borrowAmountBegin = borrowAmountBegin;
    }

    /**
     * @return borrowAmountEnd
     */
    public BigDecimal getBorrowAmountEnd() {
        return borrowAmountEnd;
    }

    /**
     * @param borrowAmountEnd 要设置的 borrowAmountEnd
     */
    public void setBorrowAmountEnd(BigDecimal borrowAmountEnd) {
        this.borrowAmountEnd = borrowAmountEnd;
    }

    public Integer getFixedSortType() {
        return fixedSortType;
    }

    public void setFixedSortType(Integer fixedSortType) {
        this.fixedSortType = fixedSortType;
    }

    /**
     * @return minBorrowAmount
     */
    public BigDecimal getMinBorrowAmount() {
        return minBorrowAmount;
    }

    /**
     * @param minBorrowAmount 要设置的 minBorrowAmount
     */
    public void setMinBorrowAmount(BigDecimal minBorrowAmount) {
        this.minBorrowAmount = minBorrowAmount;
    }

    /**
     * @return maxBorrowAmount
     */
    public BigDecimal getMaxBorrowAmount() {
        return maxBorrowAmount;
    }

    /**
     * @param maxBorrowAmount 要设置的 maxBorrowAmount
     */
    public void setMaxBorrowAmount(BigDecimal maxBorrowAmount) {
        this.maxBorrowAmount = maxBorrowAmount;
    }

    /**
     * @return amountRange
     */
    public String getAmountRange() {
        return amountRange;
    }

    /**
     * @param amountRange 要设置的 amountRange
     */
    public void setAmountRange(String amountRange) {
        this.amountRange = amountRange;
    }

    /**
     * @return periodRange
     */
    public String getPeriodRange() {
        return periodRange;
    }

    /**
     * @param periodRange 要设置的 periodRange
     */
    public void setPeriodRange(String periodRange) {
        this.periodRange = periodRange;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 要设置的 name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return minDayRate
     */
    public String getMinDayRate() {
        return minDayRate;
    }

    /**
     * @param minDayRate 要设置的 minDayRate
     */
    public void setMinDayRate(String minDayRate) {
        this.minDayRate = minDayRate;
    }

    /**
     * @return minBorrowPeriod
     */
    public Integer getMinBorrowPeriod() {
        return minBorrowPeriod;
    }

    /**
     * @param minBorrowPeriod 要设置的 minBorrowPeriod
     */
    public void setMinBorrowPeriod(Integer minBorrowPeriod) {
        this.minBorrowPeriod = minBorrowPeriod;
    }

    /**
     * @return maxBorrowPeriod
     */
    public Integer getMaxBorrowPeriod() {
        return maxBorrowPeriod;
    }

    /**
     * @param maxBorrowPeriod 要设置的 maxBorrowPeriod
     */
    public void setMaxBorrowPeriod(Integer maxBorrowPeriod) {
        this.maxBorrowPeriod = maxBorrowPeriod;
    }

    /**
     * @return logoUrl
     */
    public String getLogoUrl() {
        return logoUrl;
    }

    /**
     * @param logoUrl 要设置的 logoUrl
     */
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description 要设置的 description
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
