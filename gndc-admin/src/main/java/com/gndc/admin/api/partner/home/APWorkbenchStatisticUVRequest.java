package com.gndc.admin.api.partner.home;

import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class APWorkbenchStatisticUVRequest extends RequestMessage {

    /**
     * 产品id
     */
    @NotNull
    @Min(1)
    private Integer productId;
}
