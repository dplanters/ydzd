package com.gndc.core.mapper.simple;

import com.github.pagehelper.PageInfo;
import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.api.partner.dataAnalysis.APDataAnalysisListResponse;
import com.gndc.core.api.partner.finance.settlement.APFinanceSettlement4H5Request;
import com.gndc.core.api.partner.finance.settlement.APFinanceSettlement4H5Response;
import com.gndc.core.api.statistics.AOPartnerCostStatisticResponse;
import com.gndc.core.model.EventFee;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface EventFeeMapper extends MyMapper<EventFee, Long> {

    long selectCountByDate(@Param("feeType") Byte feeType,
                           @Param("partnerId") int partnerId,
                           @Param("feeStatus") Byte feeStatus,
                           @Param("bannerStatus") Byte status,
                           @Param("year") int year,
                           @Param("month") int month);

    List<Integer> selectProductIds(@Param("partnerId") int partnerId,
                                   @Param("feeType") Byte feeType,
                                   @Param("coopeMode") Byte coopeMode,
                                   @Param("eventType") Byte eventType,
                                   @Param("feeStatus") Byte feeStatus,
                                   @Param("bannerStatus") Byte status);

    BigDecimal selectSum(@Param("feeType") Byte feeType,
                         @Param("partnerId") int partnerId,
                         @Param("feeStatus") Byte feeStatus,
                         @Param("bannerStatus") Byte status,
                         @Param("year") int year,
                         @Param("month") int month);

    long countByPeriod(@Param("productId") Integer productId,
                       @Param("feeType") Byte feeType,
                       @Param("coopeMode") Byte coopeMode,
                       @Param("eventType") Byte eventType,
                       @Param("feeStatus") Byte feeStatus,
                       @Param("bannerStatus") Byte status,
                       @Param("startDate") Date startDate,
                       @Param("endDate") Date endDate);

    List<APDataAnalysisListResponse> apDataAnalysis(@Param("partnerId") Integer partnerId,
                                                    @Param("productId") Integer productId,
                                                    @Param("feeType") Byte feeType,
                                                    @Param("coopeMode") Byte coopeMode,
                                                    @Param("eventType") Byte eventType,
                                                    @Param("feeStatus") Byte feeStatus,
                                                    @Param("bannerStatus") Byte status,
                                                    @Param("startDate") String startDate,
                                                    @Param("endDate") String endDate);

    long apDataAnalysisCount(@Param("partnerId") int partnerId,
                             @Param("productId") Integer productId,
                             @Param("feeType") Byte feeType,
                             @Param("coopeMode") Byte coopeMode,
                             @Param("eventType") Byte eventType,
                             @Param("feeStatus") Byte feeStatus,
                             @Param("bannerStatus") Byte status,
                             @Param("startDate") String startDate,
                             @Param("endDate") String endDate);

    long selectEventFeeListCount(@Param("partnerId") Integer partnerId,
                                 @Param("productId") Integer productId,
                                 @Param("feeType") Byte feeType,
                                 @Param("coopeMode") Byte coopeMode,
                                 @Param("eventType") Byte eventType,
                                 @Param("feeStatus") Byte feeStatus,
                                 @Param("bannerStatus") Byte status,
                                 @Param("startDate") String startDate,
                                 @Param("endDate") String endDate);

    List<AOPartnerCostStatisticResponse> selectPartnerCost(@Param("partnerId") Integer partnerId,
                                                           @Param("page") PageInfo page);

    long selectPartnerCostCount(@Param("partnerId") Integer partnerId);

    List<APFinanceSettlement4H5Response> settlementList4H5(@Param("option") APFinanceSettlement4H5Request request);
}