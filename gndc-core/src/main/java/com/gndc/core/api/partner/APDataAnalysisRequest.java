package com.gndc.core.api.partner;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;
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

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.AP_DATA_ANALYSIS);
    }
}
