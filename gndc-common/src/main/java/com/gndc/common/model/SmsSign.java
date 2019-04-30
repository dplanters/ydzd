package com.gndc.common.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table(name = "dc_sms_sign")
public class SmsSign extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 短信通道id
     */
    private Integer channelId;

    /**
     * 短信通道名
     */
    private String channelName;

    /**
     * 签名
     */
    private String name;

    /**
     * 记录状态  1：正常；0：删除；
     */
    private Byte status;

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

}