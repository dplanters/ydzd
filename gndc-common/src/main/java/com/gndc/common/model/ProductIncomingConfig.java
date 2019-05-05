package com.gndc.common.model;

import com.gndc.common.model.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "dc_product_incoming_config")
public class ProductIncomingConfig extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 产品id
     */
    @Column(name = "product_id")
    private Integer productId;
    /**
     * 新客
     */
    @Column(name = "new_user")
    private Integer newUser;
    /**
     * 新客是否限制 1：限制；0：不限制；
     */
    @Column(name = "new_user_limit")
    private Byte newUserLimit;
    /**
     * 老客
     */
    @Column(name = "old_user")
    private Integer oldUser;
    /**
     * 老客是否限制 1：限制；0：不限制；
     */
    @Column(name = "old_user_limit")
    private Byte oldUserLimit;
    /**
     * 按照UV
     */
    private Integer uv;
    /**
     * 按照UV是否限制 1：限制；0：不限制；
     */
    @Column(name = "uv_limit")
    private Byte uvLimit;
    /**
     * 按照CPA
     */
    private Integer cpa;
    /**
     * 按照CPA是否限制 1：限制；0：不限制；
     */
    @Column(name = "cpa_limit")
    private Byte cpaLimit;
    /**
     * 按照CPS
     */
    private Integer cps;
    /**
     * 按照CPS是否限制 1：限制；0：不限制；
     */
    @Column(name = "cps_limit")
    private Byte cpsLimit;
    /**
     * 生效时间
     */
    @Column(name = "effect_time")
    private Date effectTime;
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