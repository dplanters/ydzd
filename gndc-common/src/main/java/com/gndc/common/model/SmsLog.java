package com.gndc.common.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table(name = "dc_sms_log")
public class SmsLog extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    private String mobile;

    private Byte smsType;

    private String smsParam;

    private String message;

    private String thirdChannel;

    private String paasooPhoneValErrcode;

    private String paasooPhoneValFormat;

    private String paasooPhoneValStr;

    private String paasooSmsMessageid;

    private String paasooSmsStatus;

    private String paasooSmsStatusCode;

    private String paasooSmsStr;

    private String paasooCallbackStatus;

    private String paasooCallbackStatusCode;

    private String paasooCallbackErrcode;

    private String paasooCallbackStr;
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