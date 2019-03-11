package com.gndc.core.api.partner;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;
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

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.A_EVENT_FEE_STATISTIC_TABLE);
    }


}
