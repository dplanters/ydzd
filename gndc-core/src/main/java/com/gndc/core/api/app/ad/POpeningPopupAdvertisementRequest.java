package com.gndc.core.api.app.ad;

import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

/**
 * banner轮播图响应
 */
@Getter
@Setter
public class POpeningPopupAdvertisementRequest extends RequestMessage {

    /**
     * 广告类型
     */
    private Byte type;
}
