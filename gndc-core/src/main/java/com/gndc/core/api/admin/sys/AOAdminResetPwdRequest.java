package com.gndc.core.api.admin.sys;

import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AOAdminResetPwdRequest extends RequestMessage {

    @NotNull
    @Min(1)
    private Integer id;

    /**
     * 新密码
     */
    @NotNull
    @NotBlank
    private String password;
}
