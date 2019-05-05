package com.gndc.common.api.admin.product.productincomingconfig;

import com.gndc.common.api.RequestMessage;
import lombok.Data;

@Data
public class AOProductIncomingConfigSearchRequest extends RequestMessage {

    private Integer productId;
    private Integer partnerId;
    private String startTime;
    private String endTime;

}