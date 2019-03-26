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
@Table(name = "dc_sms_market")
public class SmsMarket extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String mobile;

    private String message;

    private Byte status;

    private String thirdChannel;

    private String paasooPhoneValErrcode;

    private String paasooPhoneValFormat;

    private String paasooMccmnc;

    private String paasooPhoneValStr;

    private String paasooSmsMessageid;

    private String paasooSmsStatus;

    private String paasooSmsStatusCode;

    private String paasooSmsStr;

    private String paasooCallbackStatus;

    private String paasooCallbackStatusCode;

    private String paasooCallbackErrcode;

    private String paasooCallbackStr;

}