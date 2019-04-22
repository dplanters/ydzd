package com.gndc.core.service.partner.impl;

import com.gndc.common.enums.partner.EventFeeStatusEnum;
import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.core.api.partner.data.APDataAnalysisListResponse;
import com.gndc.core.api.partner.finance.settlement.APFinanceSettlement4H5Request;
import com.gndc.core.api.partner.finance.settlement.APFinanceSettlement4H5Response;
import com.gndc.core.mapper.simple.EventFeeMapper;
import com.gndc.core.model.EventFee;
import com.gndc.core.model.Partner;
import com.gndc.core.service.partner.EventFeeService;
import com.gndc.core.service.partner.PartnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author jingkaihui
 * @date 2019/2/25
 */
@Service
public class EventFeeServiceImpl extends BaseServiceImpl<EventFee, Long> implements EventFeeService {

    private static final Logger logger = LoggerFactory.getLogger(EventFeeServiceImpl.class);

    /**
     * 并发线程数。
     */
    private static final int CONCURRENCE = 2;

    @Autowired
    private PartnerService partnerService;

    @Resource
    private EventFeeMapper eventFeeMapper;

    @Override
    public List<APDataAnalysisListResponse> dataAnalysis(Integer partnerId, Integer productId, Byte feeType, Byte coopeMode, Byte eventType, Byte feeStatus,
                                                         Byte status, String startDate, String endDate) {
        return eventFeeMapper.apDataAnalysis(partnerId, productId, feeType, coopeMode, eventType, feeStatus, status, startDate, endDate);
    }

    @Override
    public void completeFee(Long eventFeeId, Integer partnerId, BigDecimal fee) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(CONCURRENCE);
        pool.execute(new CompleteThread(eventFeeId, partnerId, fee));
        pool.shutdown();
        while (!pool.isTerminated()) {
            pool.awaitTermination(5, TimeUnit.SECONDS);
        }
    }

    @Override
    public List<APFinanceSettlement4H5Response> settlementList4H5(APFinanceSettlement4H5Request request) {
        return eventFeeMapper.settlementList4H5(request);
    }

    @Override
    public long countByPeriod(Integer productId, Byte feeType, Byte coopeMode, Byte eventType, Byte feeStatus, Byte status, Date startDate, Date endDate) {
        return eventFeeMapper.countByPeriod(productId, feeType, coopeMode, eventType, feeStatus, status, startDate, endDate);
    }

    class CompleteThread extends Thread {
        private Long eventFeeId;
        private Integer partnerId;
        private BigDecimal fee;

        CompleteThread(Long eventFeeId, Integer partnerId, BigDecimal fee) {
            this.eventFeeId = eventFeeId;
            this.partnerId = partnerId;
            this.fee = fee;
        }

        public void run() {
            Partner partner = partnerService.selectByPrimaryKey(partnerId);
            Partner partnerTemp = new Partner();
            partnerTemp.setId(partnerId);
            //账户余额
            BigDecimal accountBalance = partner.getAccountBalance();
            //授信额度
            BigDecimal authAmount = partner.getAuthAmount();
            //已用授信额度
            BigDecimal authBalanceUsed = partner.getAuthBalanceUsed();
            //剩余授信额度
            BigDecimal surplusAuthAmount = authAmount.subtract(accountBalance);
            BigDecimal zero = BigDecimal.valueOf(0);
            //账户余额大于扣减的费用
            if (accountBalance.compareTo(fee) >= 0) {
                //扣减账户余额
                BigDecimal result = accountBalance.subtract(fee);
                partnerTemp.setAccountBalance(result);
            } else if (accountBalance.compareTo(fee) < 0 && surplusAuthAmount.compareTo(fee) >= 0) {
                //增加已用授信额度
                BigDecimal result = authBalanceUsed.add(fee);
                partnerTemp.setAuthBalanceUsed(result);
            } else {
                return;
            }
            partnerService.updateByPrimaryKeySelective(partnerTemp);
            EventFee eventFee = new EventFee();
            eventFee.setId(eventFeeId);
            eventFee.setFeeStatus(EventFeeStatusEnum.COMPLETE.getCode());
            updateByPrimaryKeySelective(eventFee);
        }
    }
}
