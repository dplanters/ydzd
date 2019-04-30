package com.gndc.admin.api.admin.sms;

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
     * 渠道id 1创蓝2大汉三通
     */
    private Integer channelId;

    /**
     * 签名
     */
    private String signName;

    /**
     * 消息内容
     */
    private String message;

    /**
     * 发送数量
     */
    private Integer phoneCount;

    /**
     * 创建时间开始
     */
    private String createTime;

    /**
     * 失败数量
     */
    private Integer failNum;

    /**
     * 成功数量
     */
    private Integer successNum;
}
