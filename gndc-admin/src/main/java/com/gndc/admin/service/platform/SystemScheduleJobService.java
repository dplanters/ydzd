package com.gndc.admin.service.platform;

import com.gndc.admin.api.admin.sms.*;
import com.gndc.common.model.SystemScheduleJob;
import com.gndc.common.service.BaseService;
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
