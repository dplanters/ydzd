package com.gndc.core.api.admin.product;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AOAllProductNameRequest extends RequestMessage {

    /**
     * 商户id
     */
    private Integer partnerId;

}
