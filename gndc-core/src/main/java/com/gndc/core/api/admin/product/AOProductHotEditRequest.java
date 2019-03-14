package com.gndc.core.api.admin.product;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AOProductHotEditRequest extends RequestMessage {

    /**
     * 产品id
     */
    @NotNull
    private Integer productId;

    private Integer partnerId;

    private Byte position;

    @NotNull
    private Byte hotStatus;

    /**
     * 产品附加信息
     */
    private AOProductHotEditRequest extra;

}
