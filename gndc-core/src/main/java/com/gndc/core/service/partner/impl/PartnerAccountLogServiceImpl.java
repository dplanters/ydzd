package com.gndc.core.service.partner.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gndc.common.api.HjException;
import com.gndc.common.api.Page;
import com.gndc.common.api.ResponseMessage;
import com.gndc.common.api.ResultCode;
import com.gndc.common.api.utils.ErrorUtil;
import com.gndc.common.api.utils.ValidateUtil;
import com.gndc.common.enums.partner.PartnerAccountLogStatus;
import com.gndc.common.enums.partner.PartnerAccountLogType;
import com.gndc.common.service.BaseService;
import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.common.utils.JsonUtil;
import com.gndc.core.api.partner.RechargeListRequest;
import com.gndc.core.api.partner.RechargeRecordRequest;
import com.gndc.core.api.partner.WithDrawCashListRequest;
import com.gndc.core.api.partner.WithDrawCashRecordRequest;
import com.gndc.core.mapper.simple.PartnerAccountLogMapper;
import com.gndc.core.model.PartnerAccountLog;
import com.gndc.core.service.partner.IPartnerAccountLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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
    @RequestMapping(value = "/generateRechargeRecord")
    public ResponseMessage<Boolean> generateRechargeRecord(String requestStr) {
        logger.info(String.format("请求:%s", requestStr));
        RechargeRecordRequest request = JsonUtil.getObject(requestStr, RechargeRecordRequest.class);

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

            ResponseMessage<Boolean> response = ErrorUtil.createError(new RechargeRecordRequest(), e);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);

            ResponseMessage<Boolean> response = new ResponseMessage<>(new RechargeRecordRequest());
            response.createError(ResultCode.RECORD_SAVE_FAIL);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }

    }

    @Override
    @RequestMapping(value = "/generateWithdrawCashRecord")
    public ResponseMessage<Boolean> generateWithdrawCashRecord(String requestStr) {
        logger.info(String.format("请求:%s", requestStr));
        WithDrawCashRecordRequest request = JsonUtil.getObject(requestStr, WithDrawCashRecordRequest.class);

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

            ResponseMessage<Boolean> response = ErrorUtil.createError(new WithDrawCashRecordRequest(), e);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);

            ResponseMessage<Boolean> response = new ResponseMessage<>(new WithDrawCashRecordRequest());
            response.createError(ResultCode.RECORD_SAVE_FAIL);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }
    }

    @Override
    @RequestMapping(value = "/rechargeList")
    public ResponseMessage<List<?>> rechargeList(String requestStr) {
        logger.info(String.format("请求:%s", requestStr));
        RechargeListRequest request = JsonUtil.getObject(requestStr, RechargeListRequest.class);
        ResponseMessage<List<?>> response = new ResponseMessage<>(request);

        try {
            ValidateUtil.validate(request.getHeader());

            Page page = request.getHeader().getPage();
            ValidateUtil.validatePage(page);

            Weekend<PartnerAccountLog> weekend = Weekend.of(PartnerAccountLog.class);
            Integer partnerId = 1;
            weekend.weekendCriteria()
                    .andEqualTo(PartnerAccountLog::getPartnerId, partnerId)
                    .andEqualTo(PartnerAccountLog::getType, PartnerAccountLogType.RECHARGET.getCode());

            PageHelper.startPage(page.getIndex(), page.getSize());
            List<PartnerAccountLog> rechargeList = partnerAccountLogMapper.selectByExample(weekend);

            PageInfo<PartnerAccountLog> pageInfo = new PageInfo<>(rechargeList);

            response.setData(rechargeList);
            page.setTotal(pageInfo.getTotal());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);

            response.createError(ResultCode.RECORD_SEARCH_FAIL);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }
        return response;
    }

    @Override
    @RequestMapping(value = "/withdrawList")
    public ResponseMessage<List<?>> withdrawList(String requestStr) {
        logger.info(String.format("请求:%s", requestStr));
        WithDrawCashListRequest request = JsonUtil.getObject(requestStr, WithDrawCashListRequest.class);
        ResponseMessage<List<?>> response = new ResponseMessage<>(request);

        try {
            ValidateUtil.validate(request.getHeader());

            Page page = request.getHeader().getPage();
            ValidateUtil.validatePage(page);

            List<PartnerAccountLog> withdrawCashList =
                    partnerAccountLogMapper.selectWithdrawCashList(request.getAdmin().getPartnerId(),
                            PartnerAccountLogType.WITHDRAW.getCode(), page);
            long total = partnerAccountLogMapper.selectWithdrawCashCount(request.getAdmin().getPartnerId(),
                    PartnerAccountLogType.WITHDRAW.getCode());

            response.setData(withdrawCashList);
            page.setTotal(total);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);

            response.createError(ResultCode.RECORD_SEARCH_FAIL);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }
        return response;
    }
}
