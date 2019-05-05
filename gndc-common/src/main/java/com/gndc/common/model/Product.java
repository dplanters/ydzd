package com.gndc.common.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "dc_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_no")
    private String productNo;

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
     * 借款周期单位 1：日；2：月； com.gndc.common.enums.product.BorrowPeriodUnitEnum
     */
    @Column(name = "borrow_period_unit")
    private Byte borrowPeriodUnit;

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
     * 利率单位 1：日；2：月； RateUnitEnum
     */
    @Column(name = "rate_unit")
    private Byte rateUnit;

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
     * com.gndc.common.enums.product.RepaymentMethodEnum
     */
    @Column(name = "repayment_method")
    private Byte repaymentMethod;

    /**
     * 审核类型 1：自动审核；2：人工审核；3：自动+人工；4：自动+人工初审+人工复审；
     * AutoAuditEnum
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
     * 是否可以换卡 1：可以；0：不可以； SurportChangeCardEnum
     */
    @Column(name = "surport_change_card")
    private Byte surportChangeCard;

    /**
     * 是否可以提前还款 1：可以；0：不可以；
     */
    @Column(name = "surport_prepayment")
    private Byte surportPrepayment;

    /**
     * 是否可以提额 1：可以；0：不可以；
     */
    @Column(name = "surport_improve_amount")
    private Byte surportImproveAmount;

    /**
     * 绑卡流程 1：前绑卡；2：后绑卡；
     */
    @Column(name = "card_bind_type")
    private Byte cardBindType;

    /**
     * 申请失败后再次申请时间间隔（单位：天）
     */
    @Column(name = "apply_again_time")
    private Integer applyAgainTime;

    /**
     * 是否需要确认借款页面 1：需要；0：不需要；
     */
    @Column(name = "need_confirm_page")
    private Byte needConfirmPage;
    /**
     * 确认借款页面h5 url
     */
    @Column(name = "need_confirm_page_h5_url")
    private Byte needConfirmPageH5Url;

    /**
     * 最快放款时间
     */
    @Column(name = "fastest_loan_time")
    private Integer fastestLoanTime;

    /**
     * 最快放款时间单位 1：时；2：分；3：秒；4：天
     */
    @Column(name = "fastest_loan_unit")
    private Byte fastestLoanUnit;

    /**
     * 是否支持砍头息 1：支持；0：不支持；
     */
    @Column(name = "surport_behead_rates")
    private Byte surportBeheadRates;

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
    private Byte surportExtension;

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
    private Byte status;
    /**
     * 更新者id
     */
    @Column(name = "operator_id")
    private Integer operatorId;
    //最新上线时间
    @Column(name = "last_online_time")
    private Date lastOnlineTime;
    //最新下线时间
    @Column(name = "last_offline_time")
    private Date lastOfflineTime;

    //产品支持的银行卡列表id，逗号隔开。对应systemconfig 表
    private String bankIds;
}