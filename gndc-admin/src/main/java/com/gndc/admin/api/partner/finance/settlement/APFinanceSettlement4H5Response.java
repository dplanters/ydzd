package com.gndc.admin.api.partner.finance.settlement;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class APFinanceSettlement4H5Response implements Serializable {

    /**
     * 结算记录id
     */
    private Long id;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 结算价格
     */
    private BigDecimal fee;

    private Date createTime;

    /**
     * 结算状态
     */
    private Byte feeStatus;

}
