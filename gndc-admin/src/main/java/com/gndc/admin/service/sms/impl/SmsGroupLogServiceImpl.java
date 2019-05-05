package com.gndc.admin.service.sms.impl;

import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.admin.api.admin.sms.AOSmsGroupLogListRequest;
import com.gndc.admin.api.admin.sms.AOSmsGroupLogListResponse;
import com.gndc.admin.api.admin.sms.AOSmsStatisticsRequest;
import com.gndc.admin.api.admin.sms.AOSmsStatisticsResponse;
import com.gndc.common.mapper.SmsGroupLogMapper;
import com.gndc.common.model.SmsGroupLog;
import com.gndc.admin.service.sms.SmsGroupLogService;
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
//        return smsGroupLogMapper.selectSmsGroupLogDetailList(request);
        return null;
    }

    @Override
    public List<AOSmsStatisticsResponse> groupLogStatisticsByDay(AOSmsStatisticsRequest request) {
//        return smsGroupLogMapper.groupLogStatisticsByDay(request);
        return null;
    }

    @Override
    public List<AOSmsStatisticsResponse> groupLogStatisticsByMonth(AOSmsStatisticsRequest request) {
//        return smsGroupLogMapper.groupLogStatisticsByMonth(request);
        return null;
    }
}
