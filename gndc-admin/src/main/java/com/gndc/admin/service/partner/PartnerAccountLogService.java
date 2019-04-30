package com.gndc.admin.service.partner;

import com.gndc.common.service.BaseService;
import com.gndc.admin.api.partner.finance.account.APRechargeListRequest;
import com.gndc.admin.api.partner.finance.account.APRechargeRequest;
import com.gndc.admin.api.partner.finance.account.APWithdrawListRequest;
import com.gndc.admin.api.partner.finance.account.APWithdrawRequest;
import com.gndc.common.model.PartnerAccountLog;

import java.util.List;

public interface PartnerAccountLogService extends BaseService<PartnerAccountLog, Integer> {

    /**
     * 生成一条充值记录
     *
     * @return
     */
    Boolean recharge(APRechargeRequest request);

    /**
     * 生成一条充值记录
     *
     * @return
     */
    Boolean withdraw(APWithdrawRequest request);

    /**
     * 充值记录(分页)
     *
     * @return
     */
    List<?> rechargeList(APRechargeListRequest request);

    /**
     * 提现记录(分页)
     *
     * @return
     */
    List<?> withdrawList(APWithdrawListRequest request);
}