package com.gndc.core.api.app.ad;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

/**
 * banner轮播图响应
 */
@Getter
@Setter
public class PBannerListRequest extends RequestMessage {

    /**
     * 位置
     */
    private Byte position;
}
