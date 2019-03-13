package com.gndc.core.controller.partner.finance;

import com.github.pagehelper.PageInfo;
import com.gndc.common.api.ResponseMessage;
import com.gndc.core.api.partner.finance.account.*;
import com.gndc.core.service.partner.PartnerAccountLogService;
import com.gndc.core.service.partner.PartnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/partner/finance")
public class APAccountController {

    private static final Logger logger = LoggerFactory.getLogger(APAccountController.class);

    @Autowired
    private PartnerService partnerService;

    @Autowired
    private PartnerAccountLogService partnerAccountLogService;

    @RequestMapping(value = "/account/getPartnerInfo")
    public ResponseMessage<APPartnerInfoResponse> getPartner(@Validated @RequestBody APPartnerInfoRequest request) {
        ResponseMessage<APPartnerInfoResponse> response = new ResponseMessage<>();

        APPartnerInfoResponse partnerInfo = partnerService.getPartner(request);

        response.setData(partnerInfo);

        return response;
    }

    @RequestMapping(value = "/account/recharge")
    public ResponseMessage<Boolean> recharge(@Validated @RequestBody APRechargeRequest request) {
        ResponseMessage<Boolean> response = new ResponseMessage<>();

        Boolean success = partnerAccountLogService.recharge(request);

        response.setData(success);
        return response;

    }

    @RequestMapping(value = "/account/withdraw")
    public ResponseMessage<Boolean> withdraw(@Validated @RequestBody APWithdrawRequest request) {
        ResponseMessage<Boolean> response = new ResponseMessage<>();

        Boolean success = partnerAccountLogService.withdraw(request);

        response.setData(success);
        return response;
    }

    @RequestMapping(value = "/account/rechargeList")
    public ResponseMessage<List<?>> rechargeList(@Validated @RequestBody APRechargeListRequest request) {
        ResponseMessage<List<?>> response = new ResponseMessage<>();

        List<?> rechargeList = partnerAccountLogService.rechargeList(request);

        PageInfo<?> pageInfo = new PageInfo<>(rechargeList);
        response.setData(rechargeList);
        response.setPage(pageInfo);
        return response;
    }

    @RequestMapping(value = "/account/withdrawList")
    public ResponseMessage<List<?>> withdrawList(@Validated @RequestBody APWithdrawListRequest request) {
        ResponseMessage<List<?>> response = new ResponseMessage<>();

        List<?> withdrawList = partnerAccountLogService.withdrawList(request);

        PageInfo<?> pageInfo = new PageInfo<>(withdrawList);

        response.setData(withdrawList);
        response.setPage(pageInfo);
        return response;
    }
}
