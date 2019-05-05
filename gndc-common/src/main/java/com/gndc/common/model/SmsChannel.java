package com.gndc.common.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "dc_sms_channel")
public class SmsChannel extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 短信通道名称
     */
    private String name;

    /**
     * 状态：1：正常；-1：删除
     */
    private Byte status;

}