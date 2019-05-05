/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.api.admin.product;

import com.gndc.common.api.RequestMessage;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author <a href="liujun8852@adpanshi.com">liujun</a>
 * @version V1.0.1
 * @Description
 * @date 2019/4/27  13:54
 */
@Data
public class AOProductAddRequest extends RequestMessage  {

    /**
     * logo url
     */
    @NotNull
    private String logoUrl;
    /**
     * 借贷金额开始
     */
    private BigDecimal borrowAmountMin;
    /**
     * 借贷金额结束
     */
    private BigDecimal borrowAmountMax;
    /**
     * 借款周期单位 1：日；2：月； com.gndc.common.enums.product.BorrowPeriodUnitEnum
     */
    private Byte borrowPeriodUnit;
    /**
     * 借款周期开始
     */
    private Integer borrowPeriodStart;
    /**
     * 借款周期结束
     */
    private Integer borrowPeriodEnd;
    /**
     * 日利率
     */
    private BigDecimal rate;
    /**
     * 利率单位 1：日；2：月；  RateUnitEnum
     */
    private Byte rateUnit;
    /**
     * 件均
     */
    private BigDecimal averagePrice;
    /**
     * 额度递增值
     */
    private BigDecimal incrementQuota;
    /**
     * 合作机构ID
     */
    private Integer partnerId;
    /**
     * 客服电话
     */
    private String servicePhone;
    /**
     * 产品名称
     */
    private String name;
    /**
     * 怎么还(还款方法) 1：先息后本；2：等额本息还款；3：等额本金； com.gndc.common.enums.product.RepaymentMethodEnum
     */
    private Byte repaymentMethod;
    /**
     * 审核类型 1：自动审核；2：人工审核；3：自动+人工；4：自动+人工初审+人工复审；
     */
    private Byte autoAudit;
    /**
     * 结算模式 1：UV浏览量（每天仅记一次）；2：注册推送（注册成功即收费）；3：下载收费（下载一次收费一次）；4：API计费；5：API加提成收费；
     */
    private Byte settlementMode;
    /**
     * 结算价格
     */
    private BigDecimal settlementPrice;
    /**
     * 对接模式 1：H5；2：API；
     */
    private Byte dockingMode;
    /**
     * 产品Android手机跳转地址
     */
    private String androidUrl;
    /**
     * 产品iOS手机跳转地址
     */
    private String iosUrl;
    /**
     * 还款方式(渠道) 1：主动还款；2：银行代扣；3：第三方支付；4：线下银行卡；（jsonarray）
     */
    private String repaymentChannel;
    /**
     * 线下还款账户
     */
    private String offlineAccount;
    /**
     * 线下还款账户名
     */
    private String offlineAccountName;
    /**
     * 是否可以换卡 1：可以；0：不可以；
     */
    private Byte surportChangeCard;
    /**
     * 是否可以提前还款 1：可以；0：不可以；
     */
    private Byte surportPrepayment;
    /**
     * 是否可以提额 1：可以；0：不可以；
     */
    private Byte surportImproveAmount;
    /**
     * 绑卡流程 1：前绑卡；2：后绑卡；
     */
    private Byte cardBindType;
    /**
     * 申请失败后再次申请时间间隔（单位：天）
     */
    private Integer applyAgainTime;
    /**
     * 是否需要确认借款页面 1：需要；0：不需要；
     */
    private Byte needConfirmPage;
    /**
     * 是否需要确认借款页面 1：需要；0：不需要；
     */
    private Byte needConfirmPageH5Url;
    /**
     * 最快放款时间
     */
    private Integer fastestLoanTime;
    /**
     * 最快放款时间单位 1：时；2：分；3：秒；4：天
     */
    private Byte fastestLoanUnit;
    /**
     * 是否支持砍头息 1：支持；0：不支持；
     */
    private Byte surportBeheadRates;
    /**
     * 产品形式 1：非授信产品；2：非循环授信产品；3：循环授信产品；4：授信产品；
     */
    private Byte productForm;
    /**
     * 服务费用（率）
     */
    private BigDecimal serviceCharge;
    /**
     * 风控审核费（率）
     */
    private BigDecimal riskManagementCharge;
    /**
     * 逾期费（率）
     */
    private BigDecimal overdueCharge;
    /**
     * 是否支持展期 1：支持；0：不支持；
     */
    private Byte surportExtension;
    /**
     * 申请条件
     */
    private String applyConditions;
    /**
     * 申请流程
     */
    private String applyProcess;
    /**
     * 还款说明
     */
    private String repaymentInstructions;
    /**
     * 一句话描述产品
     */
    private String description;
    /**
     * 产品状态  1：上线；0：下线；
     */
    private Byte productStatus;

    //产品支持的银行卡列表id，逗号隔开。对应systemconfig 表
    private String bankIds;

}
