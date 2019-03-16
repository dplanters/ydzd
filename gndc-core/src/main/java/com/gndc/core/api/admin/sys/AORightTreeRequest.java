package com.gndc.core.api.admin.sys;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AORightTreeRequest extends RequestMessage {

    /**
     * 平台
     */
    @NotNull
    @Min(1)
    private Byte platform;

}
