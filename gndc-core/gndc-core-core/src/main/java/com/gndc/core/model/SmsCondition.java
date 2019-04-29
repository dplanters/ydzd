package com.gndc.core.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
@Getter
@Setter
@Table(name = "dc_sms_condition")
public class SmsCondition implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 条件类型 0-未定义 1-营销 2-催收 3-提醒 4-通知
     */
    private Byte type;

    /**
     * 条件
     */
    private String condition;

    /**
     * 创建者id
     */
    @Column(name = "create_admin_id")
    private Integer createAdminId;

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