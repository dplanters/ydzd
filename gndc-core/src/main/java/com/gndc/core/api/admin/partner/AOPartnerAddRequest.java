package com.gndc.core.api.admin.partner;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class AOPartnerAddRequest extends RequestMessage {

    /**
     * 机构名称
     */
    @NotNull
    @NotBlank
    private String name;

    /**
     * 账户余额
     */
    @NotNull
    @Digits(integer = 10, fraction = 2)
    private BigDecimal accountBalance;

    /**
     * 授信额度
     */
    @Digits(integer = 10, fraction = 2)
    private BigDecimal authAmount;

}
