package com.gndc.core.api.producthot;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductHotEditRequest extends RequestMessage {
    private static final long serialVersionUID = 1L;

    // id
    private byte id;
    // 状态
    private byte status;

}
