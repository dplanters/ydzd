package com.gndc.core.service.partner;

import com.alibaba.fastjson.JSONArray;
import com.gndc.core.api.common.ResponseMessage;
import com.gndc.common.service.BaseService;
import com.gndc.core.api.finance.APFinanceExpenseTableResponse;
import com.gndc.core.api.partner.dataAnalysis.APDataAnalysisListResponse;
import com.gndc.core.api.partner.finance.settlement.APFinanceSettlement4H5Request;
import com.gndc.core.api.partner.finance.settlement.APFinanceSettlement4H5Response;
import com.gndc.core.api.statistics.AOPartnerCostStatisticResponse;
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
     * 费用统计table
     *
     * @param requestStr
     * @return
     */
    ResponseMessage<JSONArray> feeStatisticTable(String requestStr);

    /**
     * 商户后台-数据分析
     */
    List<APDataAnalysisListResponse> dataAnalysis(Integer partnerId, Integer productId, Byte feeType, Byte coopeMode, Byte eventType, Byte feeStatus,
                                                             Byte status, String startDate, String endDate);

    /**
     * 商户后台-财务结算-费用表格
     *
     * @param requestStr
     * @return
     */
    ResponseMessage<APFinanceExpenseTableResponse> apFinanceExpenseTable(String requestStr);

    /**
     * 运营后台-费用管理-机构费用列表
     *
     * @param requestStr
     * @return
     */
    ResponseMessage<List<AOPartnerCostStatisticResponse>> aoPartnerCostStatisticTable(String requestStr);

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
