package com.gndc.admin.api.app.ad;

import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * banner轮播图响应
 */
@Getter
@Setter
public class POpeningPopupAdvertisementRequest extends RequestMessage {

    /**
     * 广告类型
     */
    @NotNull
    private Byte type;
}
