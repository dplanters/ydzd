package com.gndc.core.api.partner;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class APDataAnalysisRequest extends RequestMessage {

    /**
     * 产品id
     */
    private Integer id;

    /**
     * 开始时间
     */
    @NotNull
    private String startDate;

    /**
     * 结束时间
     */
    @NotNull
    private String endDate;
}
