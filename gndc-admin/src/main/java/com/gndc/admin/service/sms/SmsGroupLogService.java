package com.gndc.admin.service.sms;

import com.gndc.admin.api.admin.sms.AOSmsGroupLogListRequest;
import com.gndc.admin.api.admin.sms.AOSmsGroupLogListResponse;
import com.gndc.admin.api.admin.sms.AOSmsStatisticsRequest;
import com.gndc.admin.api.admin.sms.AOSmsStatisticsResponse;
import com.gndc.common.model.SmsGroupLog;
import com.gndc.common.service.BaseService;

import java.util.List;

public interface SmsGroupLogService extends BaseService<SmsGroupLog, Integer> {
    List<AOSmsGroupLogListResponse> selectSmsGroupLogDetailList(AOSmsGroupLogListRequest request);

    List<AOSmsStatisticsResponse> groupLogStatisticsByDay(AOSmsStatisticsRequest request);

    List<AOSmsStatisticsResponse> groupLogStatisticsByMonth(AOSmsStatisticsRequest request);
}
