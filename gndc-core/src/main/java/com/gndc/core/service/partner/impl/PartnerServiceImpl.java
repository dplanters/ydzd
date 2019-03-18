package com.gndc.core.service.partner.impl;

import com.gndc.common.enums.partner.PartnerAccountLogStatusEnum;
import com.gndc.common.enums.partner.PartnerAccountLogTypeEnum;
import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.core.api.partner.finance.account.APPartnerInfoRequest;
import com.gndc.core.api.partner.finance.account.APPartnerInfoResponse;
import com.gndc.core.mapper.simple.PartnerAccountLogMapper;
import com.gndc.core.mapper.simple.PartnerMapper;
import com.gndc.core.model.Partner;
import com.gndc.core.service.partner.PartnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class PartnerServiceImpl extends BaseServiceImpl<Partner, Integer> implements PartnerService {

    private static final Logger logger = LoggerFactory.getLogger(PartnerServiceImpl.class);

    @Resource
    private PartnerMapper partnerMapper;

    @Resource
    private PartnerAccountLogMapper partnerAccountLogMapper;

    @Override
    public APPartnerInfoResponse getPartner(APPartnerInfoRequest request) {

        Integer partnerId = request.getAdmin().getPartnerId();
        Partner partner = partnerMapper.selectByPrimaryKey(partnerId);

        APPartnerInfoResponse partnerInfo = new APPartnerInfoResponse();

        BeanUtils.copyProperties(partner, partnerInfo);

        //充值中金额
        BigDecimal processingRechargeAmount = partnerAccountLogMapper.sumAmount(partnerId,
                PartnerAccountLogTypeEnum.RECHARGET.getCode(), PartnerAccountLogStatusEnum.RECHARGE_PROCESS.getCode());

        if (processingRechargeAmount == null) {
            processingRechargeAmount = new BigDecimal(0);
        }

        //提现中金额
        BigDecimal processingWithdrawAmount = partnerAccountLogMapper.sumAmount(partnerId,
                PartnerAccountLogTypeEnum.WITHDRAW.getCode(), PartnerAccountLogStatusEnum.WITHDRAW_PROCESS.getCode());

        if (processingWithdrawAmount == null) {
            processingWithdrawAmount = new BigDecimal(0);
        }
        partnerInfo.setAuthBalance(partnerInfo.getAuthAmount().subtract(partnerInfo.getAuthBalanceUsed()));
        partnerInfo.setProcessingRechargeAmount(processingRechargeAmount);
        partnerInfo.setProcessingWithDrawAmount(processingWithdrawAmount);

        return partnerInfo;
    }

}
