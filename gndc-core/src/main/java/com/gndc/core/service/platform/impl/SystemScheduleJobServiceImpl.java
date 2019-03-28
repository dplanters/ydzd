package com.gndc.core.service.platform.impl;

import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.core.model.SystemScheduleJob;
import com.gndc.core.service.platform.SystemScheduleJobService;
import org.springframework.stereotype.Service;

/**
 * 平台Job
 */
@Service
public class SystemScheduleJobServiceImpl extends BaseServiceImpl<SystemScheduleJob, Integer> implements SystemScheduleJobService {

    @Override
    public Integer saveJob(SystemScheduleJob systemScheduleJob) {
        return null;
    }
}
