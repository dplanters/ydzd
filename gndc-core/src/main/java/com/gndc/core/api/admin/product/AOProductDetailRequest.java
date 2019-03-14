package com.gndc.core.api.admin.product;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AOProductDetailRequest extends RequestMessage {

    /**
     * 产品id
     */
    @NotNull
    @Min(1)
    private Integer id;

}
