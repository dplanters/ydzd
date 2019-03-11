package com.gndc.core.service.partner;

import com.alibaba.fastjson.JSONArray;
import com.gndc.common.api.ResponseMessage;
import com.gndc.core.api.finance.APFinanceExpenseTableResponse;
import com.gndc.core.api.partner.APDataAnalysisTableResponse;
import com.gndc.core.api.statistics.AOPartnerCostStatisticResponse;

import java.util.List;

/**
 * @author jingkaihui
 * @date 2019/2/26
 */
public interface IEventFeeService {


    /**
     * 费用统计table
     *
     * @param requestStr
     * @return
     */
    ResponseMessage<JSONArray> feeStatisticTable(String requestStr);

    /**
     * UV统计
     *
     * @param requestStr
     * @return
     */
    ResponseMessage<JSONArray> statisticUV(String requestStr);

    /**
     * 商户后台-数据分析
     *
     * @param requestStr
     * @return
     */
    ResponseMessage<APDataAnalysisTableResponse> apDataAnalysis(String requestStr);

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
}
