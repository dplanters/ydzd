package com.gndc.core.api.finance;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class APFinanceExpenseTableRequest extends RequestMessage {

    private static final long serialVersionUID = 1L;

    /**
     * 进件id
     */
    private Integer id;

    @NotNull(message ="参数不为空")
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
