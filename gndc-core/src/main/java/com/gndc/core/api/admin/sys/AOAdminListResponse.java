package com.gndc.core.api.admin.sys;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class AOAdminListResponse implements Serializable {

    private Integer id;

    private String name;

    private String loginName;

    private Date lastLoginTime;

    private String phone;

    private Integer roleId;

    private String roleName;

    private Integer createAdminId;

    private Byte platform;

}
