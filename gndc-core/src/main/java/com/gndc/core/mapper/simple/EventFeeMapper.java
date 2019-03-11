package com.gndc.core.mapper.simple;

import com.gndc.common.api.Page;
import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.api.finance.APFinanceExpenseTableRow;
import com.gndc.core.api.partner.APDataAnalysisTableRow;
import com.gndc.core.api.statistics.AOPartnerCostStatisticResponse;
import com.gndc.core.model.EventFee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface EventFeeMapper extends MyMapper<EventFee, Long> {

    long selectCountByDate(@Param("feeType") Byte feeType,
                           @Param("partnerId") int partnerId,
                           @Param("feeStatus") Byte feeStatus,
                           @Param("status") Byte status,
                           @Param("year") int year,
                           @Param("month") int month);

    List<Integer> selectProductIds(@Param("partnerId") int partnerId,
                                   @Param("feeType") Byte feeType,
                                   @Param("coopeMode") Byte coopeMode,
                                   @Param("eventType") Byte eventType,
                                   @Param("feeStatus") Byte feeStatus,
                                   @Param("status") Byte status);

    BigDecimal selectSum(@Param("feeType") Byte feeType,
                         @Param("partnerId") int partnerId,
                         @Param("feeStatus") Byte feeStatus,
                         @Param("status") Byte status,
                         @Param("year") int year,
                         @Param("month") int month);

    long countByPeriod(@Param("partnerId") int partnerId,
                       @Param("productId") Integer productId,
                       @Param("feeType") Byte feeType,
                       @Param("coopeMode") Byte coopeMode,
                       @Param("eventType") Byte eventType,
                       @Param("feeStatus") Byte feeStatus,
                       @Param("status") Byte status,
                       @Param("startDate") String startDate,
                       @Param("endDate") String endDate);

    List<APDataAnalysisTableRow> apDataAnalysis(@Param("partnerId") int partnerId,
                                                @Param("productId") Integer productId,
                                                @Param("feeType") Byte feeType,
                                                @Param("coopeMode") Byte coopeMode,
                                                @Param("eventType") Byte eventType,
                                                @Param("feeStatus") Byte feeStatus,
                                                @Param("status") Byte status,
                                                @Param("startDate") String startDate,
                                                @Param("endDate") String endDate,
                                                @Param("page") Page page);

    long apDataAnalysisCount(@Param("partnerId") int partnerId,
                             @Param("productId") Integer productId,
                             @Param("feeType") Byte feeType,
                             @Param("coopeMode") Byte coopeMode,
                             @Param("eventType") Byte eventType,
                             @Param("feeStatus") Byte feeStatus,
                             @Param("status") Byte status,
                             @Param("startDate") String startDate,
                             @Param("endDate") String endDate);

    List<APFinanceExpenseTableRow> selectEventFeeList(@Param("partnerId") Integer partnerId,
                                                      @Param("productId") Integer productId,
                                                      @Param("feeType") Byte feeType,
                                                      @Param("coopeMode") Byte coopeMode,
                                                      @Param("eventType") Byte eventType,
                                                      @Param("feeStatus") Byte feeStatus,
                                                      @Param("status") Byte status,
                                                      @Param("startDate") String startDate,
                                                      @Param("endDate") String endDate,
                                                      @Param("page") Page page);

    long selectEventFeeListCount(@Param("partnerId") Integer partnerId,
                                 @Param("productId") Integer productId,
                                 @Param("feeType") Byte feeType,
                                 @Param("coopeMode") Byte coopeMode,
                                 @Param("eventType") Byte eventType,
                                 @Param("feeStatus") Byte feeStatus,
                                 @Param("status") Byte status,
                                 @Param("startDate") String startDate,
                                 @Param("endDate") String endDate);

    List<AOPartnerCostStatisticResponse> selectPartnerCost(@Param("partnerId") Integer partnerId,
                                                           @Param("page") Page page);

    long selectPartnerCostCount(@Param("partnerId") Integer partnerId);
}