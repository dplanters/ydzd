package com.gndc.product.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "dc_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * logo url
     */
    @Column(name = "logo_url")
    private String logoUrl;

    /**
     * 借贷金额开始
     */
    @Column(name = "borrow_amount_min")
    private BigDecimal borrowAmountMin;

    /**
     * 借贷金额结束
     */
    @Column(name = "borrow_amount_max")
    private BigDecimal borrowAmountMax;

    /**
     * 借款周期单位 1：日；2：月；
     */
    @Column(name = "borrow_period_unit")
    private Boolean borrowPeriodUnit;

    /**
     * 借款周期开始
     */
    @Column(name = "borrow_period_start")
    private Integer borrowPeriodStart;

    /**
     * 借款周期结束
     */
    @Column(name = "borrow_period_end")
    private Integer borrowPeriodEnd;

    /**
     * 日利率
     */
    private BigDecimal rate;

    /**
     * 利率单位 1：日；2：月；
     */
    @Column(name = "rate_unit")
    private Boolean rateUnit;

    /**
     * 件均
     */
    @Column(name = "average_price")
    private BigDecimal averagePrice;

    /**
     * 额度递增值
     */
    @Column(name = "increment_quota")
    private BigDecimal incrementQuota;

    /**
     * 合作机构ID
     */
    @Column(name = "partner_id")
    private Integer partnerId;

    /**
     * 客服电话
     */
    @Column(name = "service_phone")
    private String servicePhone;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 怎么还(还款方法) 1：先息后本；2：等额本息还款；3：等额本金；
     */
    @Column(name = "repayment_method")
    private Byte repaymentMethod;

    /**
     * 审核类型 1：自动审核；2：人工审核；3：自动+人工；4：自动+人工初审+人工复审；
     */
    @Column(name = "auto_audit")
    private Byte autoAudit;

    /**
     * 结算模式 1：UV浏览量（每天仅记一次）；2：注册推送（注册成功即收费）；3：下载收费（下载一次收费一次）；4：API计费；5：API加提成收费；
     */
    @Column(name = "settlement_mode")
    private Byte settlementMode;

    /**
     * 结算价格
     */
    @Column(name = "settlement_price")
    private BigDecimal settlementPrice;

    /**
     * 对接模式 1：H5；2：API；
     */
    @Column(name = "docking_mode")
    private Byte dockingMode;

    /**
     * 产品Android手机跳转地址
     */
    @Column(name = "android_url")
    private String androidUrl;

    /**
     * 产品iOS手机跳转地址
     */
    @Column(name = "ios_url")
    private String iosUrl;

    /**
     * 还款方式(渠道) 1：主动还款；2：银行代扣；3：第三方支付；4：线下银行卡；（jsonarray）
     */
    @Column(name = "repayment_channel")
    private String repaymentChannel;

    /**
     * 线下还款账户
     */
    @Column(name = "offline_account")
    private String offlineAccount;

    /**
     * 线下还款账户名
     */
    @Column(name = "offline_account_name")
    private String offlineAccountName;

    /**
     * 是否可以换卡 1：可以；0：不可以；
     */
    @Column(name = "surport_change_card")
    private Boolean surportChangeCard;

    /**
     * 是否可以提前还款 1：可以；0：不可以；
     */
    @Column(name = "surport_prepayment")
    private Boolean surportPrepayment;

    /**
     * 是否可以提额 1：可以；0：不可以；
     */
    @Column(name = "surport_improve_amount")
    private Boolean surportImproveAmount;

    /**
     * 绑卡流程 1：前绑卡；2：后绑卡；
     */
    @Column(name = "card_bind_type")
    private Boolean cardBindType;

    /**
     * 申请失败后再次申请时间间隔（单位：天）
     */
    @Column(name = "apply_again_time")
    private Integer applyAgainTime;

    /**
     * 是否需要确认借款页面 1：需要；0：不需要；
     */
    @Column(name = "need_confirm_page")
    private Boolean needConfirmPage;

    /**
     * 最快放款时间
     */
    @Column(name = "fastest_loan_time")
    private Integer fastestLoanTime;

    /**
     * 最快放款时间单位 1：时；2：分；3：秒；4：天
     */
    @Column(name = "fastest_loan_unit")
    private Boolean fastestLoanUnit;

    /**
     * 是否支持砍头息 1：支持；0：不支持；
     */
    @Column(name = "surport_behead_rates")
    private Boolean surportBeheadRates;

    /**
     * 产品形式 1：非授信产品；2：非循环授信产品；3：循环授信产品；4：授信产品；
     */
    @Column(name = "product_form")
    private Byte productForm;

    /**
     * 服务费用（率）
     */
    @Column(name = "service_charge")
    private BigDecimal serviceCharge;

    /**
     * 风控审核费（率）
     */
    @Column(name = "risk_management_charge")
    private BigDecimal riskManagementCharge;

    /**
     * 逾期费（率）
     */
    @Column(name = "overdue_charge")
    private BigDecimal overdueCharge;

    /**
     * 是否支持展期 1：支持；0：不支持；
     */
    @Column(name = "surport_extension")
    private Boolean surportExtension;

    /**
     * 申请条件
     */
    @Column(name = "apply_conditions")
    private String applyConditions;

    /**
     * 申请流程
     */
    @Column(name = "apply_process")
    private String applyProcess;

    /**
     * 还款说明
     */
    @Column(name = "repayment_instructions")
    private String repaymentInstructions;

    /**
     * 一句话描述产品
     */
    private String description;

    /**
     * 产品状态  1：上线；0：下线；
     */
    @Column(name = "product_status")
    private Byte productStatus;

    /**
     * 记录状态  1：正常；0：删除；
     */
    private Boolean status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新者id
     */
    @Column(name = "operator_id")
    private Integer operatorId;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

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
     * 获取logo url
     *
     * @return logo_url - logo url
     */
    public String getLogoUrl() {
        return logoUrl;
    }

    /**
     * 设置logo url
     *
     * @param logoUrl logo url
     */
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    /**
     * 获取借贷金额开始
     *
     * @return borrow_amount_min - 借贷金额开始
     */
    public BigDecimal getBorrowAmountMin() {
        return borrowAmountMin;
    }

    /**
     * 设置借贷金额开始
     *
     * @param borrowAmountMin 借贷金额开始
     */
    public void setBorrowAmountMin(BigDecimal borrowAmountMin) {
        this.borrowAmountMin = borrowAmountMin;
    }

    /**
     * 获取借贷金额结束
     *
     * @return borrow_amount_max - 借贷金额结束
     */
    public BigDecimal getBorrowAmountMax() {
        return borrowAmountMax;
    }

    /**
     * 设置借贷金额结束
     *
     * @param borrowAmountMax 借贷金额结束
     */
    public void setBorrowAmountMax(BigDecimal borrowAmountMax) {
        this.borrowAmountMax = borrowAmountMax;
    }

    /**
     * 获取借款周期单位 1：日；2：月；
     *
     * @return borrow_period_unit - 借款周期单位 1：日；2：月；
     */
    public Boolean getBorrowPeriodUnit() {
        return borrowPeriodUnit;
    }

    /**
     * 设置借款周期单位 1：日；2：月；
     *
     * @param borrowPeriodUnit 借款周期单位 1：日；2：月；
     */
    public void setBorrowPeriodUnit(Boolean borrowPeriodUnit) {
        this.borrowPeriodUnit = borrowPeriodUnit;
    }

    /**
     * 获取借款周期开始
     *
     * @return borrow_period_start - 借款周期开始
     */
    public Integer getBorrowPeriodStart() {
        return borrowPeriodStart;
    }

    /**
     * 设置借款周期开始
     *
     * @param borrowPeriodStart 借款周期开始
     */
    public void setBorrowPeriodStart(Integer borrowPeriodStart) {
        this.borrowPeriodStart = borrowPeriodStart;
    }

    /**
     * 获取借款周期结束
     *
     * @return borrow_period_end - 借款周期结束
     */
    public Integer getBorrowPeriodEnd() {
        return borrowPeriodEnd;
    }

    /**
     * 设置借款周期结束
     *
     * @param borrowPeriodEnd 借款周期结束
     */
    public void setBorrowPeriodEnd(Integer borrowPeriodEnd) {
        this.borrowPeriodEnd = borrowPeriodEnd;
    }

    /**
     * 获取日利率
     *
     * @return rate - 日利率
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * 设置日利率
     *
     * @param rate 日利率
     */
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    /**
     * 获取利率单位 1：日；2：月；
     *
     * @return rate_unit - 利率单位 1：日；2：月；
     */
    public Boolean getRateUnit() {
        return rateUnit;
    }

    /**
     * 设置利率单位 1：日；2：月；
     *
     * @param rateUnit 利率单位 1：日；2：月；
     */
    public void setRateUnit(Boolean rateUnit) {
        this.rateUnit = rateUnit;
    }

    /**
     * 获取件均
     *
     * @return average_price - 件均
     */
    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    /**
     * 设置件均
     *
     * @param averagePrice 件均
     */
    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

    /**
     * 获取额度递增值
     *
     * @return increment_quota - 额度递增值
     */
    public BigDecimal getIncrementQuota() {
        return incrementQuota;
    }

    /**
     * 设置额度递增值
     *
     * @param incrementQuota 额度递增值
     */
    public void setIncrementQuota(BigDecimal incrementQuota) {
        this.incrementQuota = incrementQuota;
    }

    /**
     * 获取合作机构ID
     *
     * @return partner_id - 合作机构ID
     */
    public Integer getPartnerId() {
        return partnerId;
    }

    /**
     * 设置合作机构ID
     *
     * @param partnerId 合作机构ID
     */
    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    /**
     * 获取客服电话
     *
     * @return service_phone - 客服电话
     */
    public String getServicePhone() {
        return servicePhone;
    }

    /**
     * 设置客服电话
     *
     * @param servicePhone 客服电话
     */
    public void setServicePhone(String servicePhone) {
        this.servicePhone = servicePhone;
    }

    /**
     * 获取产品名称
     *
     * @return name - 产品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置产品名称
     *
     * @param name 产品名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取怎么还(还款方法) 1：先息后本；2：等额本息还款；3：等额本金；
     *
     * @return repayment_method - 怎么还(还款方法) 1：先息后本；2：等额本息还款；3：等额本金；
     */
    public Byte getRepaymentMethod() {
        return repaymentMethod;
    }

    /**
     * 设置怎么还(还款方法) 1：先息后本；2：等额本息还款；3：等额本金；
     *
     * @param repaymentMethod 怎么还(还款方法) 1：先息后本；2：等额本息还款；3：等额本金；
     */
    public void setRepaymentMethod(Byte repaymentMethod) {
        this.repaymentMethod = repaymentMethod;
    }

    /**
     * 获取审核类型 1：自动审核；2：人工审核；3：自动+人工；4：自动+人工初审+人工复审；
     *
     * @return auto_audit - 审核类型 1：自动审核；2：人工审核；3：自动+人工；4：自动+人工初审+人工复审；
     */
    public Byte getAutoAudit() {
        return autoAudit;
    }

    /**
     * 设置审核类型 1：自动审核；2：人工审核；3：自动+人工；4：自动+人工初审+人工复审；
     *
     * @param autoAudit 审核类型 1：自动审核；2：人工审核；3：自动+人工；4：自动+人工初审+人工复审；
     */
    public void setAutoAudit(Byte autoAudit) {
        this.autoAudit = autoAudit;
    }

    /**
     * 获取结算模式 1：UV浏览量（每天仅记一次）；2：注册推送（注册成功即收费）；3：下载收费（下载一次收费一次）；4：API计费；5：API加提成收费；
     *
     * @return settlement_mode - 结算模式 1：UV浏览量（每天仅记一次）；2：注册推送（注册成功即收费）；3：下载收费（下载一次收费一次）；4：API计费；5：API加提成收费；
     */
    public Byte getSettlementMode() {
        return settlementMode;
    }

    /**
     * 设置结算模式 1：UV浏览量（每天仅记一次）；2：注册推送（注册成功即收费）；3：下载收费（下载一次收费一次）；4：API计费；5：API加提成收费；
     *
     * @param settlementMode 结算模式 1：UV浏览量（每天仅记一次）；2：注册推送（注册成功即收费）；3：下载收费（下载一次收费一次）；4：API计费；5：API加提成收费；
     */
    public void setSettlementMode(Byte settlementMode) {
        this.settlementMode = settlementMode;
    }

    /**
     * 获取结算价格
     *
     * @return settlement_price - 结算价格
     */
    public BigDecimal getSettlementPrice() {
        return settlementPrice;
    }

    /**
     * 设置结算价格
     *
     * @param settlementPrice 结算价格
     */
    public void setSettlementPrice(BigDecimal settlementPrice) {
        this.settlementPrice = settlementPrice;
    }

    /**
     * 获取对接模式 1：H5；2：API；
     *
     * @return docking_mode - 对接模式 1：H5；2：API；
     */
    public Byte getDockingMode() {
        return dockingMode;
    }

    /**
     * 设置对接模式 1：H5；2：API；
     *
     * @param dockingMode 对接模式 1：H5；2：API；
     */
    public void setDockingMode(Byte dockingMode) {
        this.dockingMode = dockingMode;
    }

    /**
     * 获取产品Android手机跳转地址
     *
     * @return android_url - 产品Android手机跳转地址
     */
    public String getAndroidUrl() {
        return androidUrl;
    }

    /**
     * 设置产品Android手机跳转地址
     *
     * @param androidUrl 产品Android手机跳转地址
     */
    public void setAndroidUrl(String androidUrl) {
        this.androidUrl = androidUrl;
    }

    /**
     * 获取产品iOS手机跳转地址
     *
     * @return ios_url - 产品iOS手机跳转地址
     */
    public String getIosUrl() {
        return iosUrl;
    }

    /**
     * 设置产品iOS手机跳转地址
     *
     * @param iosUrl 产品iOS手机跳转地址
     */
    public void setIosUrl(String iosUrl) {
        this.iosUrl = iosUrl;
    }

    /**
     * 获取还款方式(渠道) 1：主动还款；2：银行代扣；3：第三方支付；4：线下银行卡；（jsonarray）
     *
     * @return repayment_channel - 还款方式(渠道) 1：主动还款；2：银行代扣；3：第三方支付；4：线下银行卡；（jsonarray）
     */
    public String getRepaymentChannel() {
        return repaymentChannel;
    }

    /**
     * 设置还款方式(渠道) 1：主动还款；2：银行代扣；3：第三方支付；4：线下银行卡；（jsonarray）
     *
     * @param repaymentChannel 还款方式(渠道) 1：主动还款；2：银行代扣；3：第三方支付；4：线下银行卡；（jsonarray）
     */
    public void setRepaymentChannel(String repaymentChannel) {
        this.repaymentChannel = repaymentChannel;
    }

    /**
     * 获取线下还款账户
     *
     * @return offline_account - 线下还款账户
     */
    public String getOfflineAccount() {
        return offlineAccount;
    }

    /**
     * 设置线下还款账户
     *
     * @param offlineAccount 线下还款账户
     */
    public void setOfflineAccount(String offlineAccount) {
        this.offlineAccount = offlineAccount;
    }

    /**
     * 获取线下还款账户名
     *
     * @return offline_account_name - 线下还款账户名
     */
    public String getOfflineAccountName() {
        return offlineAccountName;
    }

    /**
     * 设置线下还款账户名
     *
     * @param offlineAccountName 线下还款账户名
     */
    public void setOfflineAccountName(String offlineAccountName) {
        this.offlineAccountName = offlineAccountName;
    }

    /**
     * 获取是否可以换卡 1：可以；0：不可以；
     *
     * @return surport_change_card - 是否可以换卡 1：可以；0：不可以；
     */
    public Boolean getSurportChangeCard() {
        return surportChangeCard;
    }

    /**
     * 设置是否可以换卡 1：可以；0：不可以；
     *
     * @param surportChangeCard 是否可以换卡 1：可以；0：不可以；
     */
    public void setSurportChangeCard(Boolean surportChangeCard) {
        this.surportChangeCard = surportChangeCard;
    }

    /**
     * 获取是否可以提前还款 1：可以；0：不可以；
     *
     * @return surport_prepayment - 是否可以提前还款 1：可以；0：不可以；
     */
    public Boolean getSurportPrepayment() {
        return surportPrepayment;
    }

    /**
     * 设置是否可以提前还款 1：可以；0：不可以；
     *
     * @param surportPrepayment 是否可以提前还款 1：可以；0：不可以；
     */
    public void setSurportPrepayment(Boolean surportPrepayment) {
        this.surportPrepayment = surportPrepayment;
    }

    /**
     * 获取是否可以提额 1：可以；0：不可以；
     *
     * @return surport_improve_amount - 是否可以提额 1：可以；0：不可以；
     */
    public Boolean getSurportImproveAmount() {
        return surportImproveAmount;
    }

    /**
     * 设置是否可以提额 1：可以；0：不可以；
     *
     * @param surportImproveAmount 是否可以提额 1：可以；0：不可以；
     */
    public void setSurportImproveAmount(Boolean surportImproveAmount) {
        this.surportImproveAmount = surportImproveAmount;
    }

    /**
     * 获取绑卡流程 1：前绑卡；2：后绑卡；
     *
     * @return card_bind_type - 绑卡流程 1：前绑卡；2：后绑卡；
     */
    public Boolean getCardBindType() {
        return cardBindType;
    }

    /**
     * 设置绑卡流程 1：前绑卡；2：后绑卡；
     *
     * @param cardBindType 绑卡流程 1：前绑卡；2：后绑卡；
     */
    public void setCardBindType(Boolean cardBindType) {
        this.cardBindType = cardBindType;
    }

    /**
     * 获取申请失败后再次申请时间间隔（单位：天）
     *
     * @return apply_again_time - 申请失败后再次申请时间间隔（单位：天）
     */
    public Integer getApplyAgainTime() {
        return applyAgainTime;
    }

    /**
     * 设置申请失败后再次申请时间间隔（单位：天）
     *
     * @param applyAgainTime 申请失败后再次申请时间间隔（单位：天）
     */
    public void setApplyAgainTime(Integer applyAgainTime) {
        this.applyAgainTime = applyAgainTime;
    }

    /**
     * 获取是否需要确认借款页面 1：需要；0：不需要；
     *
     * @return need_confirm_page - 是否需要确认借款页面 1：需要；0：不需要；
     */
    public Boolean getNeedConfirmPage() {
        return needConfirmPage;
    }

    /**
     * 设置是否需要确认借款页面 1：需要；0：不需要；
     *
     * @param needConfirmPage 是否需要确认借款页面 1：需要；0：不需要；
     */
    public void setNeedConfirmPage(Boolean needConfirmPage) {
        this.needConfirmPage = needConfirmPage;
    }

    /**
     * 获取最快放款时间
     *
     * @return fastest_loan_time - 最快放款时间
     */
    public Integer getFastestLoanTime() {
        return fastestLoanTime;
    }

    /**
     * 设置最快放款时间
     *
     * @param fastestLoanTime 最快放款时间
     */
    public void setFastestLoanTime(Integer fastestLoanTime) {
        this.fastestLoanTime = fastestLoanTime;
    }

    /**
     * 获取最快放款时间单位 1：时；2：分；3：秒；4：天
     *
     * @return fastest_loan_unit - 最快放款时间单位 1：时；2：分；3：秒；4：天
     */
    public Boolean getFastestLoanUnit() {
        return fastestLoanUnit;
    }

    /**
     * 设置最快放款时间单位 1：时；2：分；3：秒；4：天
     *
     * @param fastestLoanUnit 最快放款时间单位 1：时；2：分；3：秒；4：天
     */
    public void setFastestLoanUnit(Boolean fastestLoanUnit) {
        this.fastestLoanUnit = fastestLoanUnit;
    }

    /**
     * 获取是否支持砍头息 1：支持；0：不支持；
     *
     * @return surport_behead_rates - 是否支持砍头息 1：支持；0：不支持；
     */
    public Boolean getSurportBeheadRates() {
        return surportBeheadRates;
    }

    /**
     * 设置是否支持砍头息 1：支持；0：不支持；
     *
     * @param surportBeheadRates 是否支持砍头息 1：支持；0：不支持；
     */
    public void setSurportBeheadRates(Boolean surportBeheadRates) {
        this.surportBeheadRates = surportBeheadRates;
    }

    /**
     * 获取产品形式 1：非授信产品；2：非循环授信产品；3：循环授信产品；4：授信产品；
     *
     * @return product_form - 产品形式 1：非授信产品；2：非循环授信产品；3：循环授信产品；4：授信产品；
     */
    public Byte getProductForm() {
        return productForm;
    }

    /**
     * 设置产品形式 1：非授信产品；2：非循环授信产品；3：循环授信产品；4：授信产品；
     *
     * @param productForm 产品形式 1：非授信产品；2：非循环授信产品；3：循环授信产品；4：授信产品；
     */
    public void setProductForm(Byte productForm) {
        this.productForm = productForm;
    }

    /**
     * 获取服务费用（率）
     *
     * @return service_charge - 服务费用（率）
     */
    public BigDecimal getServiceCharge() {
        return serviceCharge;
    }

    /**
     * 设置服务费用（率）
     *
     * @param serviceCharge 服务费用（率）
     */
    public void setServiceCharge(BigDecimal serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    /**
     * 获取风控审核费（率）
     *
     * @return risk_management_charge - 风控审核费（率）
     */
    public BigDecimal getRiskManagementCharge() {
        return riskManagementCharge;
    }

    /**
     * 设置风控审核费（率）
     *
     * @param riskManagementCharge 风控审核费（率）
     */
    public void setRiskManagementCharge(BigDecimal riskManagementCharge) {
        this.riskManagementCharge = riskManagementCharge;
    }

    /**
     * 获取逾期费（率）
     *
     * @return overdue_charge - 逾期费（率）
     */
    public BigDecimal getOverdueCharge() {
        return overdueCharge;
    }

    /**
     * 设置逾期费（率）
     *
     * @param overdueCharge 逾期费（率）
     */
    public void setOverdueCharge(BigDecimal overdueCharge) {
        this.overdueCharge = overdueCharge;
    }

    /**
     * 获取是否支持展期 1：支持；0：不支持；
     *
     * @return surport_extension - 是否支持展期 1：支持；0：不支持；
     */
    public Boolean getSurportExtension() {
        return surportExtension;
    }

    /**
     * 设置是否支持展期 1：支持；0：不支持；
     *
     * @param surportExtension 是否支持展期 1：支持；0：不支持；
     */
    public void setSurportExtension(Boolean surportExtension) {
        this.surportExtension = surportExtension;
    }

    /**
     * 获取申请条件
     *
     * @return apply_conditions - 申请条件
     */
    public String getApplyConditions() {
        return applyConditions;
    }

    /**
     * 设置申请条件
     *
     * @param applyConditions 申请条件
     */
    public void setApplyConditions(String applyConditions) {
        this.applyConditions = applyConditions;
    }

    /**
     * 获取申请流程
     *
     * @return apply_process - 申请流程
     */
    public String getApplyProcess() {
        return applyProcess;
    }

    /**
     * 设置申请流程
     *
     * @param applyProcess 申请流程
     */
    public void setApplyProcess(String applyProcess) {
        this.applyProcess = applyProcess;
    }

    /**
     * 获取还款说明
     *
     * @return repayment_instructions - 还款说明
     */
    public String getRepaymentInstructions() {
        return repaymentInstructions;
    }

    /**
     * 设置还款说明
     *
     * @param repaymentInstructions 还款说明
     */
    public void setRepaymentInstructions(String repaymentInstructions) {
        this.repaymentInstructions = repaymentInstructions;
    }

    /**
     * 获取一句话描述产品
     *
     * @return description - 一句话描述产品
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置一句话描述产品
     *
     * @param description 一句话描述产品
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取产品状态  1：上线；0：下线；
     *
     * @return product_status - 产品状态  1：上线；0：下线；
     */
    public Byte getProductStatus() {
        return productStatus;
    }

    /**
     * 设置产品状态  1：上线；0：下线；
     *
     * @param productStatus 产品状态  1：上线；0：下线；
     */
    public void setProductStatus(Byte productStatus) {
        this.productStatus = productStatus;
    }

    /**
     * 获取记录状态  1：正常；0：删除；
     *
     * @return status - 记录状态  1：正常；0：删除；
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置记录状态  1：正常；0：删除；
     *
     * @param status 记录状态  1：正常；0：删除；
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新者id
     *
     * @return operator_id - 更新者id
     */
    public Integer getOperatorId() {
        return operatorId;
    }

    /**
     * 设置更新者id
     *
     * @param operatorId 更新者id
     */
    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}