package com.gndc.core.service.platform;

import com.gndc.common.service.BaseService;
import com.gndc.core.api.admin.sms.AOSmsScheduleListRequest;
import com.gndc.core.api.admin.sms.AOSmsScheduleListResponse;
import com.gndc.core.api.admin.sms.AOSmsTimingSendRequest;
import com.gndc.core.api.admin.sms.AOSmsUpdateTimingSendRequest;
import com.gndc.core.model.SystemScheduleJob;

import java.text.ParseException;
import java.util.List;

public interface SystemScheduleJobService extends BaseService<SystemScheduleJob, Integer> {
    Integer saveJob(SystemScheduleJob systemScheduleJob);

    List<AOSmsScheduleListResponse> selectSmsJobDetailList(AOSmsScheduleListRequest request);

    Integer timingSendJob(AOSmsTimingSendRequest request) throws ParseException;

    Integer updateTimingSendJob(AOSmsUpdateTimingSendRequest request) throws ParseException;
}
