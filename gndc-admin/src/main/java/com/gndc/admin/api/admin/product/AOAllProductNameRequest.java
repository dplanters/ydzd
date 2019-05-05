package com.gndc.admin.api.admin.product;

import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AOAllProductNameRequest extends RequestMessage {

    /**
     * 商户id
     */
    @NotNull
    @Min(1)
    private Integer partnerId;

}
