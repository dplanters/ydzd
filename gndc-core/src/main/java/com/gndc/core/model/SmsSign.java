package com.gndc.core.model;

import com.gndc.common.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
     * 状态 1正常 -1删除
     */
    private Byte status;

}