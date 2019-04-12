package com.gndc.core.service.platform;

import com.gndc.common.service.BaseService;
import com.gndc.core.api.admin.sms.*;
import com.gndc.core.model.SystemScheduleJob;
import org.quartz.SchedulerException;

import java.text.ParseException;
import java.util.List;

public interface SystemScheduleJobService extends BaseService<SystemScheduleJob, Integer> {
    Integer saveJob(SystemScheduleJob systemScheduleJob);

    void initScheduleJob();

    List<AOSmsScheduleListResponse> selectSmsJobDetailList(AOSmsScheduleListRequest request);

    Integer timingSendJob(AOSmsTimingSendRequest request) throws ParseException;

    Integer updateTimingSendJob(AOSmsUpdateTimingSendRequest request) throws SchedulerException;

    Integer stopSchedule(AOSmsStopScheduleRequest request) throws SchedulerException;
}
