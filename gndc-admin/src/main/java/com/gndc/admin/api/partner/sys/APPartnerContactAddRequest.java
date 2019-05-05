package com.gndc.admin.api.partner.sys;

import com.gndc.common.api.RequestMessage;
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
public class APPartnerContactAddRequest extends RequestMessage {
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
