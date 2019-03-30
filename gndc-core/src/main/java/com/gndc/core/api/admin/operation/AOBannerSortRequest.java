package com.gndc.core.api.admin.operation;

import com.gndc.common.api.RequestMessage;
import com.gndc.core.model.Banner;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AOBannerSortRequest extends RequestMessage {

    /**
     * 第一个banner
      */
    @NotNull
    private Banner one;

    /**
     * 第二个banner
     */
    @NotNull
    private Banner two;

}
