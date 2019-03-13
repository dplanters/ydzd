package com.gndc.core.service.partner.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gndc.common.api.ResponseMessage;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.weekend.Weekend;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
public class PartnerAccountLogServiceImpl extends BaseServiceImpl<PartnerAccountLog, Integer> implements PartnerAccountLogService {

    private static final Logger logger = LoggerFactory.getLogger(PartnerAccountLogServiceImpl.class);

    @Resource
    private PartnerAccountLogMapper partnerAccountLogMapper;

    @Override
    @RequestMapping(value = "/partner/finance/account/recharge")
    public ResponseMessage<Boolean> recharge(@RequestBody APRechargeRequest request) {

        PartnerAccountLog partnerAccountLog = new PartnerAccountLog();

        BeanUtils.copyProperties(request, partnerAccountLog);

        Date now = new Date();
        partnerAccountLog.setCreateTime(now);
        partnerAccountLog.setUpdateTime(now);

        ResponseMessage<Boolean> response = new ResponseMessage<>();

        partnerAccountLog.setPartnerId(request.getAdmin().getPartnerId());
        partnerAccountLog.setType(PartnerAccountLogType.RECHARGET.getCode());
        partnerAccountLog.setPayStatus(PartnerAccountLogStatus.RECHARGE_PROCESS.getCode());
        partnerAccountLog.setPayDate(request.getPayDate());
        int affected = partnerAccountLogMapper.insertSelective(partnerAccountLog);

        response.setData(affected == 1);
        return response;

    }

    @RequestMapping(value = "/partner/finance/account/withdraw")
    @Override
    public ResponseMessage<Boolean> withdraw(@RequestBody APWithdrawRequest request) {

        PartnerAccountLog partnerAccountLog = new PartnerAccountLog();

        BeanUtils.copyProperties(request, partnerAccountLog);

        Date now = new Date();
        partnerAccountLog.setCreateTime(now);
        partnerAccountLog.setUpdateTime(now);

        ResponseMessage<Boolean> response = new ResponseMessage<>();

        partnerAccountLog.setPartnerId(request.getAdmin().getPartnerId());

        partnerAccountLog.setType(PartnerAccountLogType.WITHDRAW.getCode());
        partnerAccountLog.setPayStatus(PartnerAccountLogStatus.WITHDRAW_PROCESS.getCode());

        int affected = partnerAccountLogMapper.insertSelective(partnerAccountLog);

        response.setData(affected == 1);
        return response;
    }

    @Override
    @RequestMapping(value = "/partner/finance/account/rechargeList")
    public ResponseMessage<List<?>> rechargeList(@RequestBody APRechargeListRequest request) {
        ResponseMessage<List<?>> response = new ResponseMessage<>();

        PageInfo page = request.getHeader().getPage();

        Weekend<PartnerAccountLog> weekend = Weekend.of(PartnerAccountLog.class);
        Integer partnerId = 1;
        weekend.weekendCriteria()
                .andEqualTo(PartnerAccountLog::getPartnerId, partnerId)
                .andEqualTo(PartnerAccountLog::getType, PartnerAccountLogType.RECHARGET.getCode());

        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<PartnerAccountLog> rechargeList = partnerAccountLogMapper.selectByExample(weekend);

        PageInfo<PartnerAccountLog> pageInfo = new PageInfo<>(rechargeList);

        response.setData(rechargeList);
        response.setPage(pageInfo);
        return response;
    }

    @Override
    @RequestMapping(value = "/partner/finance/account/withdrawList")
    public ResponseMessage<List<?>> withdrawList(@RequestBody APWithdrawListRequest request) {
        ResponseMessage<List<?>> response = new ResponseMessage<>();
        PageInfo page = request.getHeader().getPage();

        Weekend<PartnerAccountLog> weekend = Weekend.of(PartnerAccountLog.class);
        Integer partnerId = 1;
        weekend.weekendCriteria()
                .andEqualTo(PartnerAccountLog::getPartnerId, partnerId)
                .andEqualTo(PartnerAccountLog::getType, PartnerAccountLogType.WITHDRAW.getCode());

        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<PartnerAccountLog> withdrawCashList = partnerAccountLogMapper.selectByExample(weekend);

        PageInfo<PartnerAccountLog> pageInfo = new PageInfo<>(withdrawCashList);

        response.setData(withdrawCashList);
        response.setPage(pageInfo);
        return response;
    }
}
