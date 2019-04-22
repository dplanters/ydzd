package com.gndc.core.mapper;

import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.api.admin.sms.AOSmsScheduleListRequest;
import com.gndc.core.api.admin.sms.AOSmsScheduleListResponse;
import com.gndc.core.model.SystemScheduleJob;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemScheduleJobMapper extends MyMapper<SystemScheduleJob, Integer> {
    List<AOSmsScheduleListResponse> selectSmsJobDetailList(@Param("options") AOSmsScheduleListRequest request);
}