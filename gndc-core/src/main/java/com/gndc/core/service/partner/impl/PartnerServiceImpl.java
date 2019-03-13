package com.gndc.core.service.partner.impl;

import com.gndc.common.api.ResponseMessage;
import com.gndc.common.api.ResultCode;
import com.gndc.common.enums.partner.PartnerAccountLogStatus;
import com.gndc.common.enums.partner.PartnerAccountLogType;
import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.common.utils.JsonUtil;
import com.gndc.core.api.partner.common.APAllPartnerRequest;
import com.gndc.core.api.partner.finance.account.APPartnerInfoRequest;
import com.gndc.core.api.partner.finance.account.APPartnerInfoResponse;
import com.gndc.core.mapper.simple.PartnerAccountLogMapper;
import com.gndc.core.mapper.simple.PartnerMapper;
import com.gndc.core.model.Partner;
import com.gndc.core.service.partner.IPartnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@RestController
public class PartnerServiceImpl extends BaseServiceImpl<Partner, Integer> implements IPartnerService {

    private static final Logger logger = LoggerFactory.getLogger(PartnerServiceImpl.class);

    @Resource
    private PartnerMapper partnerMapper;

    @Resource
    private PartnerAccountLogMapper partnerAccountLogMapper;

    @Override
    @RequestMapping(value = "/partner/finance/account/getPartnerInfo")
    public ResponseMessage<APPartnerInfoResponse> getPartner(@RequestBody APPartnerInfoRequest request) {
        ResponseMessage<APPartnerInfoResponse> response = new ResponseMessage<>();

        try {
            Integer partnerId = request.getAdmin().getPartnerId();
            Partner partner = partnerMapper.selectByPrimaryKey(partnerId);

            APPartnerInfoResponse partnerInfo = new APPartnerInfoResponse();

            BeanUtils.copyProperties(partner, partnerInfo);

            //充值中金额
            BigDecimal processingRechargeAmount = partnerAccountLogMapper.sumAmount(partnerId,
                    PartnerAccountLogType.RECHARGET.getCode(), PartnerAccountLogStatus.RECHARGE_PROCESS.getCode());

            if (processingRechargeAmount == null) {
                processingRechargeAmount = new BigDecimal(0);
            }

            //提现中金额
            BigDecimal processingWithdrawAmount = partnerAccountLogMapper.sumAmount(partnerId,
                    PartnerAccountLogType.WITHDRAW.getCode(), PartnerAccountLogStatus.WITHDRAW_PROCESS.getCode());

            if (processingWithdrawAmount == null) {
                processingWithdrawAmount = new BigDecimal(0);
            }
            partnerInfo.setAuthBalance(partnerInfo.getAuthAmount().subtract(partnerInfo.getAuthBalanceUsed()));
            partnerInfo.setProcessingRechargeAmount(processingRechargeAmount);
            partnerInfo.setProcessingWithDrawAmount(processingWithdrawAmount);
            response.setData(partnerInfo);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);

            response.createError(ResultCode.ERROR);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }
        return response;
    }

    @Override
    @RequestMapping(value = "/partner/common/getAllPartner")
    public ResponseMessage<List<Partner>> getAllPartner(@RequestBody  APAllPartnerRequest request) {
        ResponseMessage<List<Partner>> response = new ResponseMessage<>();

        try {
            response.setData(partnerMapper.selectAll());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);

            response.createError(ResultCode.ERROR);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }
        return response;
    }
}
