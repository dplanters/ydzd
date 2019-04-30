package com.gndc.admin.api.partner.sys;

import com.gndc.common.api.RequestMessage;
import com.gndc.common.constraints.FieldsValueMatch;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@FieldsValueMatch(field = "password", fieldMatch = "confirmPassword", message = "新密码和旧密码不匹配")
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

    /**
     * 确认新密码
     */
    @NotNull
    @NotBlank
    private String confirmPassword;
}
