package com.gndc.core.api.app.ad;

import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * banner轮播图响应
 */
@Getter
@Setter
public class PBannerListRequest extends RequestMessage {

    /**
     * 位置
     */
    @NotNull
    private Byte position;
}
