package com.gndc.admin.service.partner.impl;

import com.github.pagehelper.PageHelper;
import com.gndc.common.enums.partner.PartnerAccountLogStatusEnum;
import com.gndc.common.enums.partner.PartnerAccountLogTypeEnum;
import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.admin.api.partner.finance.account.APRechargeListRequest;
import com.gndc.admin.api.partner.finance.account.APRechargeRequest;
import com.gndc.admin.api.partner.finance.account.APWithdrawListRequest;
import com.gndc.admin.api.partner.finance.account.APWithdrawRequest;
import com.gndc.common.mapper.PartnerAccountLogMapper;
import com.gndc.common.model.PartnerAccountLog;
import com.gndc.admin.service.partner.PartnerAccountLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import tk.mybatis.mapper.weekend.Weekend;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class PartnerAccountLogServiceImpl extends BaseServiceImpl<PartnerAccountLog, Integer> implements PartnerAccountLogService {

    @Resource
    private PartnerAccountLogMapper partnerAccountLogMapper;

    @Override
    public Boolean recharge(@RequestBody APRechargeRequest request) {
        PartnerAccountLog partnerAccountLog = new PartnerAccountLog();

        BeanUtils.copyProperties(request, partnerAccountLog);

        Date now = new Date();
        partnerAccountLog.setCreateTime(now);
        partnerAccountLog.setUpdateTime(now);

        partnerAccountLog.setPartnerId(request.getApAdmin().getPartnerId());
        partnerAccountLog.setType(PartnerAccountLogTypeEnum.RECHARGET.getCode());
        partnerAccountLog.setPayStatus(PartnerAccountLogStatusEnum.RECHARGE_PROCESS.getCode());
        partnerAccountLog.setPayDate(request.getPayDate());
        int affected = partnerAccountLogMapper.insertSelective(partnerAccountLog);

        return affected == 1;

    }

    @Override
    public Boolean withdraw(@RequestBody APWithdrawRequest request) {
        PartnerAccountLog partnerAccountLog = new PartnerAccountLog();

        BeanUtils.copyProperties(request, partnerAccountLog);

        Date now = new Date();
        partnerAccountLog.setCreateTime(now);
        partnerAccountLog.setUpdateTime(now);

        partnerAccountLog.setPartnerId(request.getApAdmin().getPartnerId());

        partnerAccountLog.setType(PartnerAccountLogTypeEnum.WITHDRAW.getCode());
        partnerAccountLog.setPayStatus(PartnerAccountLogStatusEnum.WITHDRAW_PROCESS.getCode());

        int affected = partnerAccountLogMapper.insertSelective(partnerAccountLog);

        return affected == 1;
    }

    @Override
    public List<?> rechargeList(@RequestBody APRechargeListRequest request) {
        Weekend<PartnerAccountLog> weekend = Weekend.of(PartnerAccountLog.class);
        Integer partnerId = request.getApAdmin().getPartnerId();
        weekend.weekendCriteria()
                .andEqualTo(PartnerAccountLog::getPartnerId, partnerId)
                .andEqualTo(PartnerAccountLog::getType, PartnerAccountLogTypeEnum.RECHARGET.getCode());

        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<PartnerAccountLog> rechargeList = partnerAccountLogMapper.selectByExample(weekend);

        return rechargeList;
    }

    @Override
    public List<?> withdrawList(@RequestBody APWithdrawListRequest request) {
        Weekend<PartnerAccountLog> weekend = Weekend.of(PartnerAccountLog.class);
        Integer partnerId = request.getApAdmin().getPartnerId();
        weekend.weekendCriteria()
                .andEqualTo(PartnerAccountLog::getPartnerId, partnerId)
                .andEqualTo(PartnerAccountLog::getType, PartnerAccountLogTypeEnum.WITHDRAW.getCode());

        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<PartnerAccountLog> withdrawCashList = partnerAccountLogMapper.selectByExample(weekend);

        return withdrawCashList;
    }
}
