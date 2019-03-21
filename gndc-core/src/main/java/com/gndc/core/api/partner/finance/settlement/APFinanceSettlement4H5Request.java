package com.gndc.core.api.partner.finance.settlement;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class APFinanceSettlement4H5Request extends RequestMessage {

    private static final long serialVersionUID = -8691645169481585687L;
    /**
     * 进件id
     */
    private Integer id;

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