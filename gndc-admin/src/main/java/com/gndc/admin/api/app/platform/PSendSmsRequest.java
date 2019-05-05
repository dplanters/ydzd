package com.gndc.admin.api.app.platform;

import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class PSendSmsRequest extends RequestMessage {

    /**
     * 手机号
     */
    @NotNull
    @NotBlank
    @Pattern(regexp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$")
    private String phone;

    /**
     * 类型 1：注册短信 2：忘记密码短信
     */
    @NotNull
    private Byte type;


}