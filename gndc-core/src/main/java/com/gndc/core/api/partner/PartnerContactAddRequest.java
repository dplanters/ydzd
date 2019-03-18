package com.gndc.core.api.partner;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * @author jingkaihui
 * @date 2019/2/25
 */
@Getter
@Setter
public class PartnerContactAddRequest extends RequestMessage {
    private static final long serialVersionUID = 1L;

    @NotNull
    private String name;

    /**
     * 手机号
     */

    @NotNull
    private String phone;

    /**
     * 邮箱
     */
    @Email
    private String email;

    /**
     * 职位
     */
    @NotNull
    private String position;

}
