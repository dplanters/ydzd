package com.gndc.common.model;

import com.gndc.common.model.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Table(name = "dc_product_access_config")
public class ProductAccessConfig extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 产品id
     */
    @Column(name = "product_id")
    private Integer productId;
    /**
     * 年龄开始
     */
    @Column(name = "age_start")
    private Byte ageStart;
    /**
     * 年龄结束
     */
    @Column(name = "age_end")
    private Byte ageEnd;
    /**
     * 是否限制地区 0：不限制 1：限制
     */
    @Column(name = "is_restricted_area")
    private Byte isRestrictedArea;
    /**
     * 限制地区
     */
    @Column(name = "restricted_area")
    private String restrictedArea;
    /**
     * 是否允许不良记录 1：允许；0：不允许；
     */
    @Column(name = "allow_bad_record")
    private Byte allowBadRecord;
    /**
     * 1-在网时长>=1年    2-在网时长>=6个月<1年
     */
    @Column(name = "network_duration")
    private Byte networkDuration;
    /**
     * 是否需要信用卡   1-需要     2-不需要
     */
    @Column(name = "need_credit_card")
    private Byte needCreditCard;
    /**
     * 教育程度   1-小学  2-初中  3-高中  4-大学  5-研究生及以上
     */
    @Column(name = "education_level")
    private Byte educationLevel;
    /**
     * 是否需要社保    1-需要   2-不需要
     */
    @Column(name = "need_social_security")
    private Byte needSocialSecurity;
    /**
     * 职业   1-上班族  2-个体工商户   3-企业主   4-自有职业
     */
    private Byte career;
    /**
     * 预筛黑名单   1-启用   2-不启用
     */
    @Column(name = "black_list_filter")
    private Byte blackListFilter;
    /**
     * 性别   1-男   2-女
     */
    private Byte sex;
    /**
     * 芝麻分  用户分值应大于字段值
     */
    @Column(name = "ali_score")
    private BigDecimal aliScore;
    /**
     * 记录状态  1：正常；0：删除；
     */
    private Byte status;
    /**
     * 更新者id
     */
    @Column(name = "operator_id")
    private Integer operatorId;
}