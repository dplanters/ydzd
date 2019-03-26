package com.gndc.core.api.partner.account;

import com.gndc.core.model.Right;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class APLoginAdminInfo implements Serializable {

    private Integer id;

    private String name;

    private String loginName;

    private Byte platform;

    private Byte superAdmin;

    private Integer partnerId;

    private Integer roleId;

    private List<Right> rights;
}
