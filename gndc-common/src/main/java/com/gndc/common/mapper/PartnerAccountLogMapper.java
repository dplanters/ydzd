package com.gndc.common.mapper;

import com.gndc.common.mybatis.MyMapper;
import com.gndc.common.model.PartnerAccountLog;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface PartnerAccountLogMapper extends MyMapper<PartnerAccountLog, Integer> {


    BigDecimal sumAmount(@Param("partnerId") Integer partnerId,
                         @Param("type") Byte type,
                         @Param("payStatus") Byte payStatus);

}