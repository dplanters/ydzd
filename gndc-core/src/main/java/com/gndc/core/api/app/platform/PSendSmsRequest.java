package com.gndc.core.api.app.platform;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PSendSmsRequest extends RequestMessage {

    /**
     * 手机号
     */
    @NotNull
    private String phone;

    /**
     * 类型 1：注册短信 2：忘记密码短信
     */
    @NotNull
    private Byte type;


}