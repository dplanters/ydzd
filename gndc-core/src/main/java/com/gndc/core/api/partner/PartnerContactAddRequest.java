package com.gndc.core.api.partner;

import com.gndc.common.api.RequestMessage;
import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;

/**
 * @author jingkaihui
 * @date 2019/2/25
 */
@Data
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
