package com.gndc.core.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "dc_sms_group_log")
@Setter
@Getter
public class SmsGroupLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 短信内容
     */
    private String message;

    /**
     * 批次号
     */
    private String uid;

    /**
     * 短信通道
     */
    @Column(name = "channel_id")
    private Integer channelId;

    /**
     * 条件id
     */
    @Column(name = "condition_id")
    private Integer conditionId;

    /**
     * 发送模式1：定时发送2：实时发送
     */
    @Column(name = "send_type")
    private Byte sendType;

    /**
     * 签名id
     */
    @Column(name = "sign_id")
    private Integer signId;

    /**
     * 响应消息
     */
    @Column(name = "response_msg")
    private String responseMsg;

    /**
     * 号码个数
     */
    @Column(name = "phone_count")
    private Integer phoneCount;

    /**
     * 失败个数
     */
    @Column(name = "fail_num")
    private Integer failNum;

    /**
     * 成功个数
     */
    @Column(name = "success_num")
    private Integer successNum;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 手机号
     */
    private String phone;
}