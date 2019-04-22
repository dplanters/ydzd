package com.gndc.core.model;

import com.gndc.common.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@Table(name = "dc_admin")
public class Admin extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer operId;

    private String name;

    private String loginName;

    private String email;

    private String password;

    private String passwordSign;

    private String operateSign;

    private Byte isLock;

    private Date lockTime;

    private Integer loginCount;

    private Date lastLoginTime;

    private String lastLoginIp;

    private Date lastLogoutTime;

    private String telephone;

    private String phone;

    private Byte platform;

    private Byte superAdmin;

    private Integer partnerId;

    private Integer roleId;

    private Byte status;

    private Integer createAdminId;

    private Integer updateAdminId;

    @Transient
    private List<Right> rights;

}