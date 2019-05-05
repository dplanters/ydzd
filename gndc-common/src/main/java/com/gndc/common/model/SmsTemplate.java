package com.gndc.common.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Table(name = "dc_sms_template")
public class SmsTemplate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 签名ID
     */
    @Column(name = "sign_id")
    private Integer signId;

    /**
     * 类型 0-未定义 1-营销类 2-催收类 3-提醒类 4-通知类
     */
    private Byte type;

    /**
     * 短信模板内容
     */
    private String content;

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