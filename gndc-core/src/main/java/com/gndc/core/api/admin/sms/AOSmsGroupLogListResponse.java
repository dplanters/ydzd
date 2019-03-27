package com.gndc.core.api.admin.sms;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AOSmsGroupLogListResponse implements Serializable {

    /**
     * 批次号
     */
    private String uid;

    /**
     * 发送模式1：定时发送2：实时发送
     */
    private Byte sendType;

    /**
     * 发送通道
     */
    private Integer channelId;

    /**
     * 短信签名
     */
    private String signName;
    /**
     * 发送内容
     */
    private String message;

    /**
     * 号码个数
     */
    private Integer phoneCount;

    /**
     * 发送状态
     */
    private String sendStatus;

    /**
     * 发送时间
     */
    private String createTime;

    /**
     * 成功数
     */
    private String successNum;
}
