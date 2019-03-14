package com.gndc.core.api.statistics;

import com.gndc.core.api.common.RequestMessage;
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
}
