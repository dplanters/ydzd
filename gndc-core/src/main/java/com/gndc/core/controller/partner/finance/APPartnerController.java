package com.gndc.core.controller.partner.finance;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gndc.core.api.common.ResponseMessage;
import com.gndc.core.api.partner.finance.account.*;
import com.gndc.core.api.partner.finance.settlement.APFinanceSettlement4H5Request;
import com.gndc.core.api.partner.finance.settlement.APFinanceSettlement4H5Response;
import com.gndc.core.service.partner.EventFeeService;
import com.gndc.core.service.partner.PartnerAccountLogService;
import com.gndc.core.service.partner.PartnerService;
import com.gndc.core.service.product.ProductService;
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
public class APPartnerController {

    private static final Logger logger = LoggerFactory.getLogger(APPartnerController.class);

    @Autowired
    private PartnerService partnerService;

    @Autowired
    private PartnerAccountLogService partnerAccountLogService;

    @Autowired
    private ProductService productService;

    @Autowired
    private EventFeeService eventFeeService;

    /**
     * 获取商户信息
     * @param request
     * @return
     */
    @RequestMapping(value = "/account/getPartnerInfo")
    public ResponseMessage<APPartnerInfoResponse> getPartner(@Validated @RequestBody APPartnerInfoRequest request) {
        ResponseMessage<APPartnerInfoResponse> response = new ResponseMessage<>();

        APPartnerInfoResponse partnerInfo = partnerService.getPartner(request);

        response.setData(partnerInfo);

        return response;
    }

    /**
     * 生成一条充值记录
     * @param request
     * @return
     */
    @RequestMapping(value = "/account/recharge")
    public ResponseMessage<Boolean> recharge(@Validated @RequestBody APRechargeRequest request) {
        ResponseMessage<Boolean> response = new ResponseMessage<>();

        Boolean success = partnerAccountLogService.recharge(request);

        response.setData(success);
        return response;

    }

    /**
     * 生成一条充值记录
     * @param request
     * @return
     */
    @RequestMapping(value = "/account/withdraw")
    public ResponseMessage<Boolean> withdraw(@Validated @RequestBody APWithdrawRequest request) {
        ResponseMessage<Boolean> response = new ResponseMessage<>();

        Boolean success = partnerAccountLogService.withdraw(request);

        response.setData(success);
        return response;
    }

    /**
     * 充值记录(分页)
     * @param request
     * @return
     */
    @RequestMapping(value = "/account/rechargeList")
    public ResponseMessage<List<?>> rechargeList(@Validated @RequestBody APRechargeListRequest request) {
        ResponseMessage<List<?>> response = new ResponseMessage<>();

        List<?> rechargeList = partnerAccountLogService.rechargeList(request);

        PageInfo<?> pageInfo = new PageInfo<>(rechargeList);
        response.setData(rechargeList);
        response.setPage(pageInfo);
        return response;
    }

    /**
     * 提现记录(分页)
     * @param request
     * @return
     */
    @RequestMapping(value = "/account/withdrawList")
    public ResponseMessage<List<?>> withdrawList(@Validated @RequestBody APWithdrawListRequest request) {
        ResponseMessage<List<?>> response = new ResponseMessage<>();

        List<?> withdrawList = partnerAccountLogService.withdrawList(request);

        PageInfo<?> pageInfo = new PageInfo<>(withdrawList);

        response.setData(withdrawList);
        response.setPage(pageInfo);
        return response;
    }

    /**
     * H5结算
     * @param request
     * @return
     */
    @RequestMapping(value = "/H5/settlementList")
    public ResponseMessage<List<APFinanceSettlement4H5Response>> settlementList4H5(@Validated @RequestBody APFinanceSettlement4H5Request request) {
        ResponseMessage<List<APFinanceSettlement4H5Response>> response = new ResponseMessage<>();
        PageInfo page = request.getHeader().getPage();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<APFinanceSettlement4H5Response> settlement4H5List = eventFeeService.settlementList4H5(request);
        PageInfo<APFinanceSettlement4H5Response> pageInfo = new PageInfo<>(settlement4H5List);
        response.setData(settlement4H5List);
        pageInfo.setList(null);
        response.setPage(pageInfo);
        return response;
    }
}
