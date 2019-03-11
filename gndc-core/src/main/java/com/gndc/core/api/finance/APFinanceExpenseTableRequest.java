package com.gndc.core.api.finance;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;
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

    @NotNull
    private Integer productId;

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
        header.setAction(HjAction.AP_FINANCE_EXPENSE_TABLE);
    }
}
