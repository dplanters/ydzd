package com.gndc.core.controller.partner.data;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gndc.common.api.ResponseMessage;
import com.gndc.common.enums.common.StatusEnum;
import com.gndc.common.enums.partner.EventFeeStatusEnum;
import com.gndc.common.enums.partner.EventFeeTypeEnum;
import com.gndc.common.enums.product.ProductCoopeModeEnum;
import com.gndc.common.enums.user.UserEventsTypeEnum;
import com.gndc.core.api.partner.data.APDataAnalysisListRequest;
import com.gndc.core.api.partner.data.APDataAnalysisListResponse;
import com.gndc.core.service.partner.EventFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/partner/data")
public class APDataAnalysisController {

    @Autowired
    private EventFeeService eventFeeService;

    /**
     * 数据分析
     * @param request
     * @return
     */
    @PostMapping("/dataAnalysis")
    public ResponseMessage<List<APDataAnalysisListResponse>> apDataAnalysis(@Validated @RequestBody APDataAnalysisListRequest request) {
        ResponseMessage<List<APDataAnalysisListResponse>> response = new ResponseMessage<>();
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        Integer partnerId = request.getApAdmin().getPartnerId();
        Integer productId = request.getProductId();
        //一个产品的统计项
        List<APDataAnalysisListResponse> dataAnalysisListResponses = eventFeeService.dataAnalysis(partnerId, productId,
                EventFeeTypeEnum.H5.getCode(),
                ProductCoopeModeEnum.CPC.getCode(), UserEventsTypeEnum.PRODUCT_CLICK.getCode(),
                EventFeeStatusEnum.COMPLETE.getCode(), StatusEnum.NORMAL.getCode(),
                request.getStartDate(), request.getEndDate());
        PageInfo<APDataAnalysisListResponse> pageInfo = new PageInfo<>(dataAnalysisListResponses);
        response.setData(dataAnalysisListResponses);
        pageInfo.setList(null);
        response.setPage(pageInfo);
        return response;
    }
}