package com.gndc.core.api.admin.product;

import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AOProductHotAddRequest extends RequestMessage {

    /**
     * 产品id
     */
    @NotNull
    private Integer productId;

    @NotNull
    private Integer partnerId;

    private Byte position;

}
