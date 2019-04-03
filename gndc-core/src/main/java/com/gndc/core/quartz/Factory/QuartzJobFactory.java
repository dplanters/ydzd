package com.gndc.core.quartz.Factory;

import com.gndc.core.model.SystemScheduleJob;
import com.gndc.core.quartz.util.TaskUtils;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 定时任务运行工厂类
 */
@DisallowConcurrentExecution
@Slf4j
public class QuartzJobFactory implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        SystemScheduleJob scheduleJob = (SystemScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
        log.info("任务名称 = [" + scheduleJob.getJobName() + "]");
        TaskUtils.invokeMethod(scheduleJob);
    }

}