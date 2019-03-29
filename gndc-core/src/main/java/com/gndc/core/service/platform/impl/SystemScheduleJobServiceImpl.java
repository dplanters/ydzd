package com.gndc.core.service.platform.impl;

import com.gndc.common.enums.ResultCode;
import com.gndc.common.exception.HjException;
import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.core.model.SystemScheduleJob;
import com.gndc.core.quartz.QuartzManager;
import com.gndc.core.service.platform.SystemScheduleJobService;
import org.quartz.CronExpression;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 平台Job
 */
@Service
public class SystemScheduleJobServiceImpl extends BaseServiceImpl<SystemScheduleJob, Integer> implements SystemScheduleJobService {

    @Autowired
    private QuartzManager quartzManager;
    @Override
    public Integer saveJob(SystemScheduleJob systemScheduleJob) {
        if (!CronExpression.isValidExpression(systemScheduleJob.getCronExpression())){
            throw new HjException(ResultCode.SMS_ILLEGAL_DATE);
        }

        if (this.insertSelective(systemScheduleJob) > 0) {
            try {
                quartzManager.addJob(systemScheduleJob);
            } catch (SchedulerException e) {
                throw new HjException(ResultCode.SYSTEM_BUSY);
            }
        }
        return 1;
    }
}
