package com.gndc.core.api.partner;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatisticUVRequest extends RequestMessage {

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.A_MANAGER_HOME_STATISTIC_UV);
    }
}
