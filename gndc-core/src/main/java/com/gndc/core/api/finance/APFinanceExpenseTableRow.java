package com.gndc.core.api.finance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class APFinanceExpenseTableRow implements Serializable {

    private Long id;

    private String phone;

    private String productName;

    @JsonIgnore
    private Integer eventId;

    /**
     * 费用金额
     */
    private BigDecimal fee;

    private Date createTime;

    /**
     * 状态
     */
    private Byte feeStatus;
}
