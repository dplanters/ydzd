package com.gndc.core.mapper.simple;

import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.model.PartnerAccountLog;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface PartnerAccountLogMapper extends MyMapper<PartnerAccountLog, Integer> {


    BigDecimal sumAmount(@Param("partnerId") Integer partnerId,
                         @Param("type") Byte type,
                         @Param("payStatus") Byte payStatus);

}