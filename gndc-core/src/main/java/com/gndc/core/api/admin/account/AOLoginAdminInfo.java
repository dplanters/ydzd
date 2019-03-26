package com.gndc.core.api.admin.account;

import com.gndc.core.model.Right;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class AOLoginAdminInfo implements Serializable {

    private Integer id;

    private String name;

    private String loginName;

    private Byte platform;

    private Byte superAdmin;

    private Integer partnerId;

    private Integer roleId;

    private List<Right> rights;
}
