package com.gndc.core.service.partner;

import com.gndc.common.service.BaseService;
import com.gndc.core.api.partner.data.APDataAnalysisListResponse;
import com.gndc.core.api.partner.finance.settlement.APFinanceSettlement4H5Request;
import com.gndc.core.api.partner.finance.settlement.APFinanceSettlement4H5Response;
import com.gndc.core.model.EventFee;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author jingkaihui
 * @date 2019/2/26
 */
public interface EventFeeService extends BaseService<EventFee, Long> {


    /**
     * 商户后台-数据分析
     */
    List<APDataAnalysisListResponse> dataAnalysis(Integer partnerId, Integer productId, Byte feeType, Byte coopeMode, Byte eventType, Byte feeStatus,
                                                             Byte status, String startDate, String endDate);

    /**
     * 费用结算
     *
     * @param eventFeeId
     * @param partnerId
     * @param fee
     */
    void completeFee(Long eventFeeId, Integer partnerId, BigDecimal fee) throws InterruptedException;

    /**
     * H5结算
     *
     * @param request
     * @return
     */
    List<APFinanceSettlement4H5Response> settlementList4H5(APFinanceSettlement4H5Request request);

    long countByPeriod(Integer productId, Byte feeType, Byte coopeMode, Byte eventType, Byte feeStatus, Byte status, Date startDate, Date endDate);
}
