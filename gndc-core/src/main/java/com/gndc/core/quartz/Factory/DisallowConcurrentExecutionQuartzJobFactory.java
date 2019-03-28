package com.gndc.core.quartz.Factory;

import com.gndc.core.model.SystemScheduleJob;
import com.gndc.core.quartz.util.TaskUtils;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 定时任务运行工厂类
 */
@DisallowConcurrentExecution
public class DisallowConcurrentExecutionQuartzJobFactory implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        SystemScheduleJob scheduleJob = (SystemScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
        System.out.println("任务名称 = [" + scheduleJob.getJobName() + "]");
        TaskUtils.invokeMethod(scheduleJob);
    }

}