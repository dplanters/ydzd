package com.gndc.core.controller.partner.dataAnalysis;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gndc.common.enums.common.StatusEnum;
import com.gndc.common.enums.partner.EventFeeStatusEnum;
import com.gndc.common.enums.partner.EventFeeTypeEnum;
import com.gndc.common.enums.product.ProductCoopeModeEnum;
import com.gndc.common.enums.user.UserEventsTypeEnum;
import com.gndc.core.api.common.ResponseMessage;
import com.gndc.core.api.partner.dataAnalysis.APDataAnalysisListRequest;
import com.gndc.core.api.partner.dataAnalysis.APDataAnalysisListResponse;
import com.gndc.core.service.partner.EventFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/partner/dataAnalysis")
public class ApDataAnalysisController {

    @Autowired
    private EventFeeService eventFeeService;

    @PostMapping("/apDataAnalysis")
    public ResponseMessage<List<APDataAnalysisListResponse>> apDataAnalysis(@Validated @RequestBody APDataAnalysisListRequest request) {
        ResponseMessage<List<APDataAnalysisListResponse>> response = new ResponseMessage<>();
        PageInfo page = request.getHeader().getPage();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        Integer partnerId = request.getAdmin().getPartnerId();
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
