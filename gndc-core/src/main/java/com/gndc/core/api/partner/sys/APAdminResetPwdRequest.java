package com.gndc.core.api.partner.sys;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class APAdminResetPwdRequest extends RequestMessage {

    /**
     * 旧密码
     */
    @NotNull
    @NotBlank
    private String oldPassword;

    /**
     * 新密码
     */
    @NotNull
    @NotBlank
    private String password;
}
