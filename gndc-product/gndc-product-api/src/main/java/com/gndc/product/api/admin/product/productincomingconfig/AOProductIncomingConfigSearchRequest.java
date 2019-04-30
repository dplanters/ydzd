package com.gndc.product.api.admin.product.productincomingconfig;

import com.gndc.common.api.RequestMessage;
import lombok.Data;

import java.util.Date;

@Data
public class AOProductIncomingConfigSearchRequest extends RequestMessage {

    private Integer productId;
    private Integer partnerId;
    private Date startTime;
    private Date endTime;

}