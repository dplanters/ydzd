package com.gndc.core.service.partner;

import com.gndc.common.api.ResponseMessage;
import com.gndc.common.service.BaseService;
import com.gndc.core.api.partner.finance.account.APRechargeListRequest;
import com.gndc.core.api.partner.finance.account.APRechargeRequest;
import com.gndc.core.api.partner.finance.account.APWithdrawListRequest;
import com.gndc.core.api.partner.finance.account.APWithdrawRequest;
import com.gndc.core.model.PartnerAccountLog;

import java.util.List;

public interface IPartnerAccountLogService extends BaseService<PartnerAccountLog, Integer> {

    /**
     * 生成一条充值记录
     *
     * @return
     */
    ResponseMessage<Boolean> recharge(APRechargeRequest request);

    /**
     * 生成一条充值记录
     *
     * @return
     */
    ResponseMessage<Boolean> withdraw(APWithdrawRequest request);

    /**
     * 充值记录(分页)
     *
     * @return
     */
    ResponseMessage<List<?>> rechargeList(APRechargeListRequest request);

    /**
     * 提现记录(分页)
     *
     * @return
     */
    ResponseMessage<List<?>> withdrawList(APWithdrawListRequest request);
}