package com.gndc.core.api.statistics;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

/**
 * @author jingkaihui
 * @date 2019/3/6
 */
@Getter
@Setter
public class AOPartnerCostStatisticRequest extends RequestMessage {

    /**
     * 商户id
     */
    private Integer partnerId;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.AO_COST_MANAGER_PARTNER_COST_LIST);
    }
}
