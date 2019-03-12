package com.gndc.core.service.partner.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gndc.common.api.HjException;
import com.gndc.common.api.Page;
import com.gndc.common.api.ResponseMessage;
import com.gndc.common.api.ResultCode;
import com.gndc.common.api.utils.ErrorUtil;
import com.gndc.common.api.utils.ValidateUtil;
import com.gndc.common.enums.admin.RightType;
import com.gndc.common.enums.common.StatusType;
import com.gndc.common.enums.partner.EventFeeStatus;
import com.gndc.common.enums.partner.EventFeeType;
import com.gndc.common.enums.product.CoopeMode;
import com.gndc.common.enums.user.UserEventsType;
import com.gndc.common.model.Admin;
import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.common.utils.DateUtil;
import com.gndc.common.utils.JsonUtil;
import com.gndc.core.api.finance.APFinanceExpenseTableRequest;
import com.gndc.core.api.finance.APFinanceExpenseTableResponse;
import com.gndc.core.api.finance.APFinanceExpenseTableRow;
import com.gndc.core.api.partner.*;
import com.gndc.core.api.statistics.AOPartnerCostStatisticRequest;
import com.gndc.core.api.statistics.AOPartnerCostStatisticResponse;
import com.gndc.core.mapper.simple.EventFeeMapper;
import com.gndc.core.mapper.simple.ProductMapper;
import com.gndc.core.mapper.simple.UserEventMapper;
import com.gndc.core.mapper.simple.UserMapper;
import com.gndc.core.model.EventFee;
import com.gndc.core.model.Product;
import com.gndc.core.model.User;
import com.gndc.core.model.UserEvent;
import com.gndc.core.service.partner.IEventFeeService;
import com.sun.rowset.internal.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.weekend.Weekend;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * @author jingkaihui
 * @date 2019/2/25
 */
@RestController
public class EventFeeServiceImpl extends BaseServiceImpl<EventFee, Long> implements IEventFeeService {

    private static final Logger logger = LoggerFactory.getLogger(EventFeeServiceImpl.class);
    @Resource
    private EventFeeMapper eventFeeMapper;

    @Resource
    private ProductMapper productMapper;

    @Resource
    private UserEventMapper userEventMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    @RequestMapping(value = "/feeStatisticTable")
    public ResponseMessage<JSONArray> feeStatisticTable(String requestStr) {
        logger.info(String.format("请求:%s", requestStr));
        FeeStatisticTableRequest request = JsonUtil.getObject(requestStr, FeeStatisticTableRequest.class);
        ResponseMessage<JSONArray> response = new ResponseMessage<>(request);
        try {
            ValidateUtil.validateBean(request);

            Admin admin = request.getAdmin();

            com.gndc.common.common.utils.VerifyRightUtil.verifyRight(request.getAdmin(), RightType.BILL_STATISTIC_TABLE);

            LocalDate now = LocalDate.now();

            //h5总数 已结算的数量
            long h5Count = eventFeeMapper.selectCountByDate(EventFeeType.H5.getCode(), admin.getPartnerId(),
                    EventFeeStatus.COMPLETE.getCode(), StatusType.NORMAL.getCode(), now.getYear(), request.getMonth());
            //h5总数 已结算+未结算
            long h5CountTotal = eventFeeMapper.selectCountByDate(EventFeeType.H5.getCode(), admin.getPartnerId(),
                    null, StatusType.NORMAL.getCode(), now.getYear(), request.getMonth());

            //api总数 已结算的数量
            long apiCount = eventFeeMapper.selectCountByDate(EventFeeType.API.getCode(), admin.getPartnerId(),
                    EventFeeStatus.COMPLETE.getCode(), StatusType.NORMAL.getCode(), now.getYear(), request.getMonth());

            //api总数 已结算+未结算
            long apiCountTotal = eventFeeMapper.selectCountByDate(EventFeeType.API.getCode(), admin.getPartnerId(),
                    null, StatusType.NORMAL.getCode(), now.getYear(), request.getMonth());

            //h5 已结算金额
            BigDecimal h5Sum = eventFeeMapper.selectSum(EventFeeType.H5.getCode(), admin.getPartnerId(),
                    EventFeeStatus.COMPLETE.getCode(), StatusType.NORMAL.getCode(), now.getYear(),
                    request.getMonth());
            if (h5Sum == null) {
                h5Sum = new BigDecimal(0);
            }

            //api 已结算金额
            BigDecimal apiSum = eventFeeMapper.selectSum(EventFeeType.API.getCode(), admin.getPartnerId(),
                    EventFeeStatus.COMPLETE.getCode(), StatusType.NORMAL.getCode(), now.getYear(),
                    request.getMonth());

            if (apiSum == null) {
                apiSum = new BigDecimal(0);
            }

            JSONArray array = new JSONArray();

            JSONObject api = new JSONObject()
                    .fluentPut("category", "API结算")
                    .fluentPut("count", apiCount)
                    .fluentPut("amount", apiSum)
                    .fluentPut("rate", apiCountTotal == 0 ? 0 : String.format("%.2f",
                            apiCount / (apiCountTotal * 1.0)));
            array.fluentAdd(api);

            JSONObject h5 = new JSONObject()
                    .fluentPut("category", "H5结算")
                    .fluentPut("count", h5Count)
                    .fluentPut("amount", h5Sum)
                    .fluentPut("rate", h5CountTotal == 0 ? 0 : String.format("%.2f", h5Count / (h5CountTotal * 1.0)));
            array.fluentAdd(h5);

            JSONObject total = new JSONObject()
                    .fluentPut("category", "总计")
                    .fluentPut("count", h5Count + apiCount)
                    .fluentPut("amount", h5Sum.add(apiSum));
            array.fluentAdd(total);

            response.setData(array);
            return response;
        } catch (HjException e) {
            logger.error(e.getMessage(), e);

            response.createError(e);
            response = ErrorUtil.createError(new FeeStatisticTableRequest(), e);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);

            response = new ResponseMessage<>(new FeeStatisticTableRequest());
            response.createError(ResultCode.ERROR);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }
    }

    @Override
    @PostMapping("/statisticUV")
    public ResponseMessage<JSONArray> statisticUV(String requestStr) {
        StatisticUVRequest request = JsonUtil.getObject(requestStr, StatisticUVRequest.class);
        ResponseMessage<JSONArray> response = new ResponseMessage<>(request);
        try {
            ValidateUtil.validateBean(request);

            LocalDateTime now = LocalDateTime.now();
            int minute = now.getMinute();

            int startMinute = minute >= 30 ? 30 : 0;

            int endMinute = minute >= 30 ? 59 : 29;

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DateUtil.FORMAT_2);

            LocalDateTime currentStartDateTime = LocalDateTime.of(now.getYear(), now.getMonthValue(),
                    now.getDayOfMonth(), now.getHour(), startMinute, 0);
            LocalDateTime currentEndDateTime = LocalDateTime.of(now.getYear(), now.getMonthValue(), now.getDayOfMonth(),
                    now.getHour(), endMinute, 59);
            LocalDateTime yesterStartDateTime = currentStartDateTime.minus(1, ChronoUnit.DAYS);
            LocalDateTime yesterEndDateTime = currentEndDateTime.minus(1, ChronoUnit.DAYS);

            Integer partnerId = request.getAdmin().getPartnerId();

            List<Integer> productIds = eventFeeMapper.selectProductIds(partnerId, EventFeeType.H5.getCode(),
                    CoopeMode.CPA.getCode(), UserEventsType.PRODUCT_CLICK.getCode(),
                    EventFeeStatus.COMPLETE.getCode(), StatusType.NORMAL.getCode());

            JSONArray data = new JSONArray();
            for (int i = 0; i < productIds.size(); i++) {

                //当前时段UV数（半小时）
                Integer productId = productIds.get(i);
                long currentPeriodCount = eventFeeMapper.countByPeriod(partnerId, productId,
                        EventFeeType.H5.getCode(),
                        CoopeMode.CPA.getCode(), UserEventsType.PRODUCT_CLICK.getCode(),
                        EventFeeStatus.COMPLETE.getCode(), StatusType.NORMAL.getCode(),
                        currentStartDateTime.format(dtf)
                        , currentEndDateTime.format(dtf));

                //昨天同时段UV数（半小时）
                long yesterSamePeriodCount = eventFeeMapper.countByPeriod(partnerId, productId,
                        EventFeeType.H5.getCode(),
                        CoopeMode.CPA.getCode(), UserEventsType.PRODUCT_CLICK.getCode(),
                        EventFeeStatus.COMPLETE.getCode(), StatusType.NORMAL.getCode(),
                        yesterStartDateTime.format(dtf)
                        , yesterEndDateTime.format(dtf));


                long diff = currentPeriodCount - yesterSamePeriodCount;

                StringBuffer tendency;
                if (diff >= 0) {
                    String rate = "0.00";
                    if (yesterSamePeriodCount != 0) {
                        rate = String.format("%.2f", diff / (1.0 * yesterSamePeriodCount));
                    }
                    tendency = new StringBuffer("+").append(rate).append("%");
                } else {
                    String rate = "0.00";
                    if (yesterSamePeriodCount != 0) {
                        rate = String.format("%.2f", diff / (1.0 * yesterSamePeriodCount));
                    }
                    tendency = new StringBuffer(rate).append("%");
                }

                Product product = productMapper.selectByPrimaryKey(productId);

                JSONObject item = new JSONObject();
                item
                        .fluentPut("name", product.getName())
                        .fluentPut("item", "UV量")
                        .fluentPut("currentPeriodCount", currentPeriodCount)
                        .fluentPut("yesterSamePeriodCount", yesterSamePeriodCount)
                        .fluentPut("tendency", tendency);

                data.add(item);
            }

            response.setData(data);
            return response;
        } catch (HjException e) {
            logger.error(e.getMessage(), e);
            response.createError(e);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response.createError(ResultCode.ERROR);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }
    }

    @Override
    @PostMapping("/apDataAnalysis")
    public ResponseMessage<APDataAnalysisTableResponse> apDataAnalysis(String requestStr) {
        APDataAnalysisRequest request = JsonUtil.getObject(requestStr, APDataAnalysisRequest.class);
        ResponseMessage<APDataAnalysisTableResponse> response = new ResponseMessage<>(request);
        try {
            PageInfo page = request.getHeader().getPage();
            ValidateUtil.validateBean(request);

//            Integer partnerId = request.getAdmin().getPartnerId();

            Integer partnerId = 1;
            APDataAnalysisTableResponse apDataAnalysisTableResponse = new APDataAnalysisTableResponse();

            Integer productId = request.getId();
            Product product = productMapper.selectByPrimaryKey(productId);

            apDataAnalysisTableResponse.setProductName(product.getName());

            Weekend<EventFee> weekend = Weekend.of(EventFee.class);
            weekend.weekendCriteria()
                    .andEqualTo(EventFee::getPartnerId, partnerId)
                    .andEqualTo(EventFee::getProductId, productId)
                    .andEqualTo(EventFee::getFeeType, EventFeeType.H5.getCode())
                    .andEqualTo(EventFee::getCoopeMode, CoopeMode.CPC.getCode())
                    .andEqualTo(EventFee::getEventType, UserEventsType.PRODUCT_CLICK.getCode())
                    .andEqualTo(EventFee::getFeeStatus, EventFeeStatus.COMPLETE.getCode())
                    .andEqualTo(EventFee::getStatus, StatusType.NORMAL.getCode())
                    .andGreaterThanOrEqualTo(EventFee::getCreateTime, request.getStartDate())
                    .andLessThanOrEqualTo(EventFee::getCreateTime, request.getEndDate());
            //一个产品的统计项
            List<APDataAnalysisTableRow> rows = eventFeeMapper.apDataAnalysis(partnerId, productId,
                    EventFeeType.H5.getCode(),
                    CoopeMode.CPC.getCode(), UserEventsType.PRODUCT_CLICK.getCode(),
                    EventFeeStatus.COMPLETE.getCode(), StatusType.NORMAL.getCode(),
                    request.getStartDate(), request.getEndDate(), page);

            PageInfo<APDataAnalysisTableRow> pageInfo = new PageInfo<>(rows);

            apDataAnalysisTableResponse.setRows(rows);
            response.getHeader().setPage(pageInfo);
            response.setData(apDataAnalysisTableResponse);

            return response;
        } catch (HjException e) {
            logger.error(e.getMessage(), e);
            response.createError(e);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response.createError(ResultCode.ERROR);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }
    }

    @Override
    @PostMapping(value = "/apFinanceExpenseTable")
    public ResponseMessage<APFinanceExpenseTableResponse> apFinanceExpenseTable(String requestStr) {
        APFinanceExpenseTableRequest request = JsonUtil.getObject(requestStr, APFinanceExpenseTableRequest.class);
        ResponseMessage<APFinanceExpenseTableResponse> response = new ResponseMessage<>(request);
        try {
            PageInfo page = request.getHeader().getPage();
            ValidateUtil.validateBean(request);

            Integer productId = request.getProductId();
            Product product = productMapper.selectByPrimaryKey(productId);

            APFinanceExpenseTableResponse apFinanceExpenseTableResponse = new APFinanceExpenseTableResponse();

            apFinanceExpenseTableResponse.setProductName(product.getName());

            //一个产品的统计项
            List<APFinanceExpenseTableRow> rows = eventFeeMapper.selectEventFeeList(request.getAdmin().getPartnerId(),
                    productId, null, null, null, EventFeeStatus.COMPLETE.getCode(), StatusType.NORMAL.getCode(),
                    request.getStartDate(), request.getEndDate(), page);

            for (int i = 0; i < rows.size(); i++) {
                Integer eventId = rows.get(i).getEventId();
                UserEvent userEvent = userEventMapper.selectByPrimaryKey(eventId);
                User user = userMapper.selectByPrimaryKey(userEvent.getUserId());
                rows.get(i).setPhone(user.getPhone());
            }

            apFinanceExpenseTableResponse.setRows(rows);

            response.setData(apFinanceExpenseTableResponse);
            response.getHeader().setPage(page);
            return response;
        } catch (HjException e) {
            logger.error(e.getMessage(), e);
            response.createError(e);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response.createError(ResultCode.ERROR);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }
    }

    @Override
    @PostMapping(value = "/aoPartnerCostStatisticTable")
    public ResponseMessage<List<AOPartnerCostStatisticResponse>> aoPartnerCostStatisticTable(String requestStr) {
        AOPartnerCostStatisticRequest request = JsonUtil.getObject(requestStr, AOPartnerCostStatisticRequest.class);
        ResponseMessage<List<AOPartnerCostStatisticResponse>> response = new ResponseMessage<>(request);
        try {
            PageInfo page = request.getHeader().getPage();
            ValidateUtil.validateBean(request);

            Integer partnerId = request.getPartnerId();
            List<AOPartnerCostStatisticResponse> aoPartnerCostStatisticResponses = eventFeeMapper.selectPartnerCost(partnerId, page);
            long total = eventFeeMapper.selectPartnerCostCount(partnerId);

            response.setData(aoPartnerCostStatisticResponses);
            response.getHeader().getPage().setTotal(total);

            return response;
        } catch (HjException e) {
            logger.error(e.getMessage(), e);
            response.createError(e);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            response.createError(ResultCode.ERROR);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }
    }
}
