package com.gndc.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gndc.common.model.BaseEntity;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Getter;
import lombok.Setter;
import tk.mybatis.mapper.annotation.LogicDelete;

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

    @JsonIgnore
    private String password;

    @JsonIgnore
    private String passwordSign;

    @JsonIgnore
    private String operateSign;

    private Byte isLock;

    private Date lockTime;

    private Integer loginCount;

    private Date lastLoginTime;

    private String lastLoginIp;

    private Date lastLogoutTime;

    private String telephone;

    private String phone;

    private Byte level;

    private Integer partnerId;

    private Integer roleId;

    @LogicDelete(notDeletedValue = 1, isDeletedValue = -1)
    private Byte status;

    private Integer createAdminId;

    private Integer updateAdminId;

    @Transient
    private List<Right> rights;

}