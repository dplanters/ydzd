package com.gndc.admin.api.admin.operation;

import com.gndc.common.api.RequestMessage;
import com.gndc.admin.dto.BannerDTO;
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
    private BannerDTO one;

    /**
     * 第二个banner
     */
    @NotNull
    private BannerDTO two;

}
