package com.gndc.core.api.finance;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class APFinanceExpenseTableResponse implements Serializable {

    private String productName;

    private List<APFinanceExpenseTableRow> rows;

}