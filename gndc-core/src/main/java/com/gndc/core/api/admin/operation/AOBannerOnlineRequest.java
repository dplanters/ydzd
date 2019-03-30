package com.gndc.core.api.admin.operation;

import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AOBannerOnlineRequest extends RequestMessage {

    @NotNull
    @Min(1)
    private Integer id;

}
