package com.gndc.core.service.sms.impl;

import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.core.api.admin.sms.AOSmsGroupLogListRequest;
import com.gndc.core.api.admin.sms.AOSmsGroupLogListResponse;
import com.gndc.core.api.admin.sms.AOSmsStatisticsRequest;
import com.gndc.core.api.admin.sms.AOSmsStatisticsResponse;
import com.gndc.core.mapper.SmsGroupLogMapper;
import com.gndc.core.model.SmsGroupLog;
import com.gndc.core.service.sms.SmsGroupLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 短信群发记录
 */
@Service
public class SmsGroupLogServiceImpl extends BaseServiceImpl<SmsGroupLog, Integer> implements SmsGroupLogService {

    @Resource
    private SmsGroupLogMapper smsGroupLogMapper;

    @Override
    public List<AOSmsGroupLogListResponse> selectSmsGroupLogDetailList(AOSmsGroupLogListRequest request) {
        return smsGroupLogMapper.selectSmsGroupLogDetailList(request);
    }

    @Override
    public List<AOSmsStatisticsResponse> groupLogStatisticsByDay(AOSmsStatisticsRequest request) {
        return smsGroupLogMapper.groupLogStatisticsByDay(request);
    }

    @Override
    public List<AOSmsStatisticsResponse> groupLogStatisticsByMonth(AOSmsStatisticsRequest request) {
        return smsGroupLogMapper.groupLogStatisticsByMonth(request);
    }
}
