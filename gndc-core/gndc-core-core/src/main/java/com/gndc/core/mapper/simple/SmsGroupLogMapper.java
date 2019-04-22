package com.gndc.core.mapper.simple;

import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.api.admin.sms.AOSmsGroupLogListRequest;
import com.gndc.core.api.admin.sms.AOSmsGroupLogListResponse;
import com.gndc.core.api.admin.sms.AOSmsStatisticsRequest;
import com.gndc.core.api.admin.sms.AOSmsStatisticsResponse;
import com.gndc.core.model.SmsGroupLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmsGroupLogMapper extends MyMapper<SmsGroupLog, Integer> {
    List<AOSmsGroupLogListResponse> selectSmsGroupLogDetailList(@Param("options") AOSmsGroupLogListRequest request);

    List<AOSmsStatisticsResponse> groupLogStatisticsByDay(@Param("options") AOSmsStatisticsRequest request);

    List<AOSmsStatisticsResponse> groupLogStatisticsByMonth(@Param("options") AOSmsStatisticsRequest request);
}