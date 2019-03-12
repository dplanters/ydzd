package com.gndc.core.service.partner.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gndc.common.api.HjException;
import com.gndc.common.api.ResponseMessage;
import com.gndc.common.api.ResultCode;
import com.gndc.common.api.utils.ErrorUtil;
import com.gndc.common.api.utils.ValidateUtil;
import com.gndc.common.enums.partner.PartnerAccountLogStatus;
import com.gndc.common.enums.partner.PartnerAccountLogType;
import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.common.utils.JsonUtil;
import com.gndc.core.api.partner.finance.account.APRechargeListRequest;
import com.gndc.core.api.partner.finance.account.APRechargeRequest;
import com.gndc.core.api.partner.finance.account.APWithdrawListRequest;
import com.gndc.core.api.partner.finance.account.APWithdrawRequest;
import com.gndc.core.mapper.simple.PartnerAccountLogMapper;
import com.gndc.core.model.PartnerAccountLog;
import com.gndc.core.service.partner.IPartnerAccountLogService;
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
public class PartnerAccountLogServiceImpl extends BaseServiceImpl<PartnerAccountLog, Integer> implements IPartnerAccountLogService {

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

        try {
            ValidateUtil.validate(request.getHeader());
            ResponseMessage<Boolean> response = new ResponseMessage<>(request);

            partnerAccountLog.setPartnerId(request.getAdmin().getPartnerId());
            partnerAccountLog.setType(PartnerAccountLogType.RECHARGET.getCode());
            partnerAccountLog.setPayStatus(PartnerAccountLogStatus.RECHARGE_PROCESS.getCode());
            partnerAccountLog.setPayDate(request.getPayDate());
            int affected = partnerAccountLogMapper.insertSelective(partnerAccountLog);

            response.setData(affected == 1);
            return response;
        } catch (HjException e) {
            logger.error(e.getMessage(), e);

            ResponseMessage<Boolean> response = ErrorUtil.createError(new APRechargeRequest(), e);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);

            ResponseMessage<Boolean> response = new ResponseMessage<>(new APRechargeRequest());
            response.createError(ResultCode.RECORD_SAVE_FAIL);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }

    }

    @RequestMapping(value = "/partner/finance/account/withdraw")
    @Override
    public ResponseMessage<Boolean> withdraw(@RequestBody APWithdrawRequest request) {

        PartnerAccountLog partnerAccountLog = new PartnerAccountLog();

        BeanUtils.copyProperties(request, partnerAccountLog);

        Date now = new Date();
        partnerAccountLog.setCreateTime(now);
        partnerAccountLog.setUpdateTime(now);

        try {
            ValidateUtil.validate(request.getHeader());
            ResponseMessage<Boolean> response = new ResponseMessage<>(request);

            partnerAccountLog.setPartnerId(request.getAdmin().getPartnerId());

            partnerAccountLog.setType(PartnerAccountLogType.WITHDRAW.getCode());
            partnerAccountLog.setPayStatus(PartnerAccountLogStatus.WITHDRAW_PROCESS.getCode());

            int affected = partnerAccountLogMapper.insertSelective(partnerAccountLog);

            response.setData(affected == 1);
            return response;
        } catch (HjException e) {
            logger.error(e.getMessage(), e);

            ResponseMessage<Boolean> response = ErrorUtil.createError(new APWithdrawRequest(), e);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);

            ResponseMessage<Boolean> response = new ResponseMessage<>(new APWithdrawRequest());
            response.createError(ResultCode.RECORD_SAVE_FAIL);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }
    }

    @Override
    @RequestMapping(value = "/partner/finance/account/rechargeList")
    public ResponseMessage<List<?>> rechargeList(@RequestBody APRechargeListRequest request) {
        ResponseMessage<List<?>> response = new ResponseMessage<>(request);

        try {
            ValidateUtil.validate(request.getHeader());

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
            response.getHeader().setPage(pageInfo);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);

            response.createError(ResultCode.RECORD_SEARCH_FAIL);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }
        return response;
    }

    @Override
    @RequestMapping(value = "/partner/finance/account/withdrawList")
    public ResponseMessage<List<?>> withdrawList(@RequestBody APWithdrawListRequest request) {
        ResponseMessage<List<?>> response = new ResponseMessage<>(request);

        try {
            ValidateUtil.validate(request.getHeader());

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
            response.getHeader().setPage(pageInfo);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);

            response.createError(ResultCode.RECORD_SEARCH_FAIL);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }
        return response;
    }
}
