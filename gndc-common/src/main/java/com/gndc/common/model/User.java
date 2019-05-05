package com.gndc.common.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Table(name = "dc_user")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String phone;

    private String uid;

    private String facebookAcc;

    private String fbUserName;

    private String fbAccountkitId;

    private String whatsappAcc;

    private String name;

    private String password;

    private String passwordSign;

    private Integer areaId;

    private String headPhoto;

    private Byte sex;

    private String birthday;

    private Integer provinceId;

    private Integer cityId;

    private String education;

    private String job;

    private BigDecimal income;

    private Short collectionQuantity;

    private String regChannel;

    private Byte regDevice;

    private Date regTime;

    private String regDevicetoken;

    private String regTermType;

    private String imei;

    private Date lastLoginTime;

    private String lastLoginIp;

    private Byte lastLoginDevice;

    private String lastLoginDevicetoken;

    private Date lastLogoutTime;

    private Byte userStatus;

    private String remark;

    private String appName;

    private String appPackage;

}