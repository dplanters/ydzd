package com.gndc.core.controller.partner.home;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import com.gndc.common.api.ResponseMessage;
import com.gndc.common.enums.common.StatusEnum;
import com.gndc.common.enums.partner.EventFeeStatusEnum;
import com.gndc.common.enums.partner.EventFeeTypeEnum;
import com.gndc.common.enums.product.ProductCoopeModeEnum;
import com.gndc.common.enums.user.UserEventsTypeEnum;
import com.gndc.core.api.partner.home.APWorkbenchStatisticUVRequest;
import com.gndc.core.api.partner.home.APWorkbenchStatisticUVResponse;
import com.gndc.core.model.Product;
import com.gndc.core.service.partner.EventFeeService;
import com.gndc.core.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;

@RestController
@RequestMapping("/partner/home")
public class APWorkbenchController {

    @Autowired
    private ProductService productService;

    @Autowired
    private EventFeeService eventFeeService;

    /**
     * 工作台-UV统计
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/statisticUV")
    public ResponseMessage<APWorkbenchStatisticUVResponse> settlementList4H5(@Validated @RequestBody APWorkbenchStatisticUVRequest request) throws ParseException {
        ResponseMessage<APWorkbenchStatisticUVResponse> response = new ResponseMessage<>();

        Integer productId = request.getProductId();
        Product product = productService.selectByPrimaryKey(productId);
        APWorkbenchStatisticUVResponse workbenchStatisticUVResponse = new APWorkbenchStatisticUVResponse();
        if (product != null) {
            //今天开始时间
            Date beginDate = DateUtil.beginOfDay(DateUtil.date()).toJdkDate();
            //今天结束时间
            Date endDate = DateUtil.date().toJdkDate();
            //昨天开始时间
            Date yBeginDate = DateUtil.date(beginDate).offset(DateField.DAY_OF_MONTH, -1);
            //昨天结束时间
            Date yEndDate = DateUtil.date(endDate).offset(DateField.DAY_OF_MONTH, -1);


            //当天0点到当前时段UV
            long currentPeriodCount = eventFeeService.countByPeriod(productId,
                    EventFeeTypeEnum.H5.getCode(),
                    ProductCoopeModeEnum.CPC.getCode(), UserEventsTypeEnum.PRODUCT_CLICK.getCode(),
                    EventFeeStatusEnum.COMPLETE.getCode(), StatusEnum.NORMAL.getCode(),
                    beginDate, endDate);

            //昨天对应时段UV
            long yesterSamePeriodCount = eventFeeService.countByPeriod(productId,
                    EventFeeTypeEnum.H5.getCode(),
                    ProductCoopeModeEnum.CPC.getCode(), UserEventsTypeEnum.PRODUCT_CLICK.getCode(),
                    EventFeeStatusEnum.COMPLETE.getCode(), StatusEnum.NORMAL.getCode(),
                    yBeginDate, yEndDate);


            String tendency = "";
            if (currentPeriodCount == 0 && yesterSamePeriodCount == 0) {
                tendency = "0.00%";
            } else if (currentPeriodCount != 0 && yesterSamePeriodCount == 0) {
                tendency = "+100.00%";
            } else if (currentPeriodCount == 0) {
                tendency = "0.00%";
            } else {
                tendency = String.format("%.2f", currentPeriodCount * 100 / 1.0 * yesterSamePeriodCount) + "%";
            }
            workbenchStatisticUVResponse.setName(product.getName());
            workbenchStatisticUVResponse.setItem("");
            workbenchStatisticUVResponse.setCurrentPeriodCount(currentPeriodCount);
            workbenchStatisticUVResponse.setYesterSamePeriodCount(yesterSamePeriodCount);
            workbenchStatisticUVResponse.setTendency(tendency);
        }
        response.setData(workbenchStatisticUVResponse);
        return response;
    }
}
