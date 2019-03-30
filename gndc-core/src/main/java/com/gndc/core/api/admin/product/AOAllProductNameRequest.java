package com.gndc.core.api.admin.product;

import com.gndc.common.api.RequestMessage;
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
