package com.gndc.core.service.partner.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gndc.common.enums.partner.PartnerAccountLogStatus;
import com.gndc.common.enums.partner.PartnerAccountLogType;
import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.core.api.partner.finance.account.APRechargeListRequest;
import com.gndc.core.api.partner.finance.account.APRechargeRequest;
import com.gndc.core.api.partner.finance.account.APWithdrawListRequest;
import com.gndc.core.api.partner.finance.account.APWithdrawRequest;
import com.gndc.core.mapper.simple.PartnerAccountLogMapper;
import com.gndc.core.model.PartnerAccountLog;
import com.gndc.core.service.partner.PartnerAccountLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import tk.mybatis.mapper.weekend.Weekend;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class PartnerAccountLogServiceImpl extends BaseServiceImpl<PartnerAccountLog, Integer> implements PartnerAccountLogService {

    private static final Logger logger = LoggerFactory.getLogger(PartnerAccountLogServiceImpl.class);

    @Resource
    private PartnerAccountLogMapper partnerAccountLogMapper;

    @Override
    public Boolean recharge(@RequestBody APRechargeRequest request) {
        PartnerAccountLog partnerAccountLog = new PartnerAccountLog();

        BeanUtils.copyProperties(request, partnerAccountLog);

        Date now = new Date();
        partnerAccountLog.setCreateTime(now);
        partnerAccountLog.setUpdateTime(now);

        partnerAccountLog.setPartnerId(request.getAdmin().getPartnerId());
        partnerAccountLog.setType(PartnerAccountLogType.RECHARGET.getCode());
        partnerAccountLog.setPayStatus(PartnerAccountLogStatus.RECHARGE_PROCESS.getCode());
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

        partnerAccountLog.setPartnerId(request.getAdmin().getPartnerId());

        partnerAccountLog.setType(PartnerAccountLogType.WITHDRAW.getCode());
        partnerAccountLog.setPayStatus(PartnerAccountLogStatus.WITHDRAW_PROCESS.getCode());

        int affected = partnerAccountLogMapper.insertSelective(partnerAccountLog);

        return affected == 1;
    }

    @Override
    public List<?> rechargeList(@RequestBody APRechargeListRequest request) {
        PageInfo page = request.getHeader().getPage();

        Weekend<PartnerAccountLog> weekend = Weekend.of(PartnerAccountLog.class);
        Integer partnerId = request.getAdmin().getPartnerId();
        weekend.weekendCriteria()
                .andEqualTo(PartnerAccountLog::getPartnerId, partnerId)
                .andEqualTo(PartnerAccountLog::getType, PartnerAccountLogType.RECHARGET.getCode());

        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<PartnerAccountLog> rechargeList = partnerAccountLogMapper.selectByExample(weekend);

        return rechargeList;
    }

    @Override
    public List<?> withdrawList(@RequestBody APWithdrawListRequest request) {
        PageInfo page = request.getHeader().getPage();

        Weekend<PartnerAccountLog> weekend = Weekend.of(PartnerAccountLog.class);
        Integer partnerId = request.getAdmin().getPartnerId();
        weekend.weekendCriteria()
                .andEqualTo(PartnerAccountLog::getPartnerId, partnerId)
                .andEqualTo(PartnerAccountLog::getType, PartnerAccountLogType.WITHDRAW.getCode());

        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<PartnerAccountLog> withdrawCashList = partnerAccountLogMapper.selectByExample(weekend);

        return withdrawCashList;
    }
}
