package com.gndc.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class AOAdminLoginInfoDTO implements Serializable {

    private Integer id;

    private String name;

    private String loginName;

    private Byte platform;

    private Byte superAdmin;

    private Integer partnerId;

    private Integer roleId;

    private List<RightInfoDTO> rights;
}
