package com.gndc.product.model;

import com.gndc.common.model.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "dc_product_show_config")
public class ProductShowConfig extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 产品id
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 马甲包渠道id
     */
    @Column(name = "channel_id")
    private Integer channelId;

    /**
     * 展示模块 1：首页-精选爆款；5：找贷款；15：极速贷；
     */
    @Column(name = "show_module")
    private Byte showModule;

    /**
     * 展示位置
     */
    @Column(name = "show_position")
    private Byte showPosition;

    /**
     * 马甲 1：上线；0：下线
     */
    @Column(name = "online_status")
    private Byte onlineStatus;

    /**
     * 最新上线时间
     */
    @Column(name = "last_online_time")
    private Date lastOnlineTime;

    /**
     * 最新下线时间
     */
    @Column(name = "last_offline_time")
    private Date lastOfflineTime;

    /**
     * 固定位置
     */
    @Column(name = "fixed_position")
    private Byte fixedPosition;
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