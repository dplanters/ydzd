package com.gndc.core.api.producthot;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductHotListRequest extends RequestMessage {

    // 产品名称
    private String productName;
    // 状态
    private byte status;

}
