package com.gndc.core.api.producthot;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductHotSortRequest extends RequestMessage {
    private static final long serialVersionUID = 1L;

    // 位置下调项的id
    private int downId;

    // 位置上调项的id
    private int upperId;

    // 位置下调项的position
    private int downPosition;

    // 位置上调项的position
    private int upperPosition;

}
