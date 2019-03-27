package com.gndc.core.api.partner.data;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class APDataAnalysisListRequest extends RequestMessage {

    /**
     * 产品id
     */
    @NotNull
    private Integer productId;

    /**
     * 开始时间
     */
    private String startDate;

    /**
     * 结束时间
     */
    private String endDate;
}
