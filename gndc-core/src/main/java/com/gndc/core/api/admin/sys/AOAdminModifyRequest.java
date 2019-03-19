package com.gndc.core.api.admin.sys;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AOAdminModifyRequest extends RequestMessage {
    @NotNull
    @Min(1)
    private Integer id;
    /**
     * 工号
     */
    private Integer operId;
    /**
     * 成员姓名，真实姓名
     */
    @NotNull
    @NotBlank
    private String name;

    private String partnerName;
    /**
     * 角色名 id
     */
    @NotNull
    @Min(1)
    private Integer roleId;

    /**
     * 手机号
     */
    private String phone;
    /**
     * 登录名
     */
    @NotNull
    @NotBlank
    private String loginName;

    @NotNull
    @NotBlank
    private String password;

    @NotNull
    @Min(1)
    private Integer level;

    private Integer partnerId;

}
