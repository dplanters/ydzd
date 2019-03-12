package com.gndc.core.service.partner;

import com.gndc.common.api.ResponseMessage;
import com.gndc.core.api.partner.RechargeListRequest;
import com.gndc.core.api.partner.WithDrawCashListRequest;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IPartnerAccountLogService {

    /**
     * 生成一条充值记录
     *
     * @param requestStr
     * @return
     */
    ResponseMessage<Boolean> generateRechargeRecord(@RequestParam String requestStr);

    /**
     * 生成一条充值记录
     *
     * @param requestStr
     * @return
     */
    ResponseMessage<Boolean> generateWithdrawCashRecord(@RequestParam String requestStr);

    /**
     * 充值记录(分页)
     *
     * @param requestStr
     * @return
     */
    ResponseMessage<List<?>> rechargeList(RechargeListRequest request);

    /**
     * 提现记录(分页)
     *
     * @param requestStr
     * @return
     */
    ResponseMessage<List<?>> withdrawList(WithDrawCashListRequest request);
}