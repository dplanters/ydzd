package com.gndc.core.api.admin.operation;

import com.gndc.core.api.common.RequestMessage;
import com.gndc.core.model.Admin;
import com.gndc.core.model.Banner;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

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
