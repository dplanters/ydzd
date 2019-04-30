package com.gndc.admin.api.admin.partner;

import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class AOPartnerModifyRequest extends RequestMessage {

    @NotNull
    @Min(1)
    private Integer id;

    /**
     * 机构名称
     */
    @NotNull
    @NotBlank
    private String name;

    /**
     * 授信额度
     */
    @NotNull
    @Digits(integer = 10, fraction = 2)
    private BigDecimal authAmount;

}
