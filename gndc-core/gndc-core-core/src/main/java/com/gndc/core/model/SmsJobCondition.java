package com.gndc.core.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "dc_sms_job_condition")
@Getter
@Setter
public class SmsJobCondition implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 条件id
     */
    @Column(name = "condition_id")
    private Integer conditionId;

    /**
     * 渠道id
     */
    @Column(name = "channel_id")
    private Integer channelId;

    /**
     * 签名id
     */
    @Column(name = "sign_ids")
    private String signIds;

    /**
     * 模板id
     */
    @Column(name = "template_id")
    private Integer templateId;

    /**
     * 运营商id 1:移动，2：联通，3：电信
     */
    @Column(name = "operator_ids")
    private String operatorIds;

    /**
     * 创建者id
     */
    @Column(name = "create_admin_id")
    private Integer createAdminId;

    /**
     * 状态  1：正常；0：删除
     */
    private Byte status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 电话
     */
    private String phones;
}