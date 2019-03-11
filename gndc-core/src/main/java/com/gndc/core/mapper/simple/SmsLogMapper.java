package com.gndc.core.mapper.simple;

import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.model.SmsLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SmsLogMapper extends MyMapper<SmsLog, Integer> {
    int batInsert(@Param("list") List<SmsLog> list);

    SmsLog selectByPaasooSmsMessageid(String messageid);
}