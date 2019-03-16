package com.gndc.core.api.admin.sys;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AOAdminAddModifyRequest extends RequestMessage {

    /**
     * 工号
     */
    private int operId;
    /**
     * 成员姓名，真实姓名
     */
    @NotNull
    @NotBlank
    private String name;

    @NotBlank
    private String partnerName;
    /**
     * 角色名 id
     */
    @NotNull
    @Min(1)
    private int roleId;

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
    private int level;

    private int partnerId;

}
