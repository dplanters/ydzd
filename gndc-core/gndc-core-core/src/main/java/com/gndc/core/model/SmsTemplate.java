package com.gndc.core.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
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
     * 状态 1正常 -1删除
     */
    private Byte status;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 创建者id
     */
    @Column(name = "create_admin_id")
    private Integer createAdminId;

}