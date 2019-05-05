package com.gndc.common.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "dc_settlement")
public class Settlement extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 产品id
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 合作机构ID
     */
    @Column(name = "partner_id")
    private Integer partnerId;

    /**
     * 费用金额
     */
    private BigDecimal fee;

    /**
     * 结算模式 1：UV浏览量（每天仅记一次）；5：注册推送（注册成功即收费）；15：下载收费（下载一次收费一次）；20：API计费；25：API加提成收费；
     */
    @Column(name = "settlement_mode")
    private Byte settlementMode;

    /**
     * 费用状态 1：已结算；0：未结算
     */
    @Column(name = "settlement_status")
    private Byte settlementStatus;

    /**
     * 结算时间
     */
    @Column(name = "settlement_time")
    private Date settlementTime;

    /**
     * 备注
     */
    private String remarks;

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