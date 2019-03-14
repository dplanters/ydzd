package com.gndc.core.api.partner;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author jingkaihui
 * @date 2019/2/26
 */
@Getter
@Setter
public class FeeStatisticTableRequest extends RequestMessage {

    private static final long serialVersionUID = 1L;

    @NonNull
    @Min(1)
    @Max(12)
    private Integer month;

}
