package com.gndc.core.mapper.simple;

import com.gndc.common.api.Page;
import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.model.PartnerAccountLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface PartnerAccountLogMapper extends MyMapper<PartnerAccountLog, Integer> {

    List<PartnerAccountLog> selectRechargeList(@Param("partnerId") Integer partnerId,
                                               @Param("type") Byte type,
                                               @Param("page") Page page);

    long selectRechargeCount(@Param("partnerId") Integer partnerId,
                             @Param("type") Byte type);

    List<PartnerAccountLog> selectWithdrawCashList(
            @Param("partnerId") Integer partnerId,
            @Param("type") Byte type,
            @Param("page") Page page);

    long selectWithdrawCashCount(@Param("partnerId") Integer partnerId,
                                 @Param("type") Byte type);

    BigDecimal sumAmount(@Param("partnerId") Integer partnerId,
                         @Param("type") Byte type,
                         @Param("payStatus") Byte payStatus);

}