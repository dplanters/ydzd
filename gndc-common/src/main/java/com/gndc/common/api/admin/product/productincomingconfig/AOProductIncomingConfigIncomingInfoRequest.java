package com.gndc.common.api.admin.product.productincomingconfig;

import com.gndc.common.api.RequestMessage;
import lombok.Data;

@Data
public class AOProductIncomingConfigIncomingInfoRequest extends RequestMessage {

    private Integer productId;
}