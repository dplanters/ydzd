package com.gndc.core.api.partner.product;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class APWorkbenchStatisticUVRequest extends RequestMessage {

    /**
     * 产品id
     */
    @NotNull
    private Integer productId;
}
