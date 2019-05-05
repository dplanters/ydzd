package com.gndc.common.api.admin.product.productaccessconfig;

import com.gndc.common.api.RequestMessage;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class AOProductAccessConfigAddRquest extends RequestMessage {

    /**
     * 产品id
     */
    @NotNull
    private Integer productId;
    /**
     * 年龄开始
     */
    private Byte ageStart;
    /**
     * 年龄结束
     */
    private Byte ageEnd;
    /**
     * 是否限制地区 0：不限制 1：限制
     */
    private Byte isRestrictedArea;
    /**
     * 限制地区
     */
    private String restrictedArea;
    /**
     * 是否允许不良记录 1：允许；0：不允许；
     */
    private Byte allowBadRecord;
    /**
     * 1-在网时长>=1年    2-在网时长>=6个月<1年
     */
    private Byte networkDuration;
    /**
     * 是否需要信用卡   1-需要     2-不需要
     */
    private Byte needCreditCard;
    /**
     * 教育程度   1-小学  2-初中  3-高中  4-大学  5-研究生及以上
     */
    private Byte educationLevel;
    /**
     * 是否需要社保    1-需要   2-不需要
     */
    private Byte needSocialSecurity;
    /**
     * 职业   1-上班族  2-个体工商户   3-企业主   4-自有职业
     */
    private Byte career;
    /**
     * 预筛黑名单   1-启用   2-不启用
     */
    private Byte blackListFilter;
    /**
     * 性别   1-男   2-女
     */
    private Byte sex;
    /**
     * 芝麻分  用户分值应大于字段值
     */
    private BigDecimal aliScore;
}