package com.gndc.core.service.platform.impl;

import cn.hutool.core.util.IdUtil;
import com.gndc.common.constant.SmsEditConstant;
import com.gndc.common.enums.ResultCode;
import com.gndc.common.enums.common.StatusEnum;
import com.gndc.common.enums.job.JobConcurrentEnum;
import com.gndc.common.enums.job.JobGroupEnum;
import com.gndc.common.enums.job.JobRunStatusEnum;
import com.gndc.common.exception.HjException;
import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.core.api.admin.sms.*;
import com.gndc.core.mapper.SystemScheduleJobMapper;
import com.gndc.core.mappers.SmsJobConditionMapping;
import com.gndc.core.model.SmsCondition;
import com.gndc.core.model.SmsJobCondition;
import com.gndc.core.model.SystemScheduleJob;
import com.gndc.core.quartz.QuartzManager;
import com.gndc.core.service.platform.SystemScheduleJobService;
import com.gndc.core.service.sms.SmsConditionService;
import com.gndc.core.service.sms.SmsJobConditionService;
import com.gndc.core.service.sms.SmsLogService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.CronExpression;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

/**
 * 平台Job
 */
@Service
@Slf4j
public class SystemScheduleJobServiceImpl extends BaseServiceImpl<SystemScheduleJob, Integer> implements SystemScheduleJobService {

    @Autowired
    private SmsJobConditionMapping smsJobConditionMapping;

    @Autowired
    private QuartzManager quartzManager;

    @Autowired
    private SmsConditionService smsConditionService;

    @Autowired
    private SmsJobConditionService smsJobConditionService;

    @Autowired
    private SystemScheduleJobService systemScheduleJobService;

    @Resource
    private SystemScheduleJobMapper systemScheduleJobMapper;

    @Autowired
    private SmsLogService smsLogService;

    @Override
    public Integer saveJob(SystemScheduleJob systemScheduleJob) {
        if (!CronExpression.isValidExpression(systemScheduleJob.getCronExpression())) {
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

    @Override
    @PostConstruct
    public void initScheduleJob() {
        List<SystemScheduleJob> jobList = this.selectAll();
        if (jobList != null && jobList.size() > 0) {
            for (SystemScheduleJob systemScheduleJob : jobList) {
                if (systemScheduleJob.getJobStatus().equals(JobRunStatusEnum.STATUS_RUNNING.getCode())
                        && systemScheduleJob.getStatus().equals(StatusEnum.NORMAL.getCode())) {
                    try {
                        quartzManager.addJob(systemScheduleJob);
                    } catch (SchedulerException e) {
                        log.error("job初始化失败-----------id:" + systemScheduleJob.getId());
                        throw new HjException(ResultCode.SMS_ILLEGAL_CRON);
                    }
                }

            }


        }
    }

    @Override
    public List<AOSmsScheduleListResponse> selectSmsJobDetailList(AOSmsScheduleListRequest request) {
        return systemScheduleJobMapper.selectSmsJobDetailList(request);
    }

    @Override
    @Transactional
    public Integer timingSendJob(AOSmsTimingSendRequest request) throws ParseException {
        //需要发送短信的号码用","隔开
        String phoneToSend = null;
        SmsJobCondition smsJobCondition = smsJobConditionMapping.convert(request);
        if (request.getSourceType().equals(SmsEditConstant.SOURCE_TYPE_1)) {
            SmsCondition smsCondition = smsConditionService.selectByPrimaryKey(request.getConditionId());
            //当前支持营销类
            if (smsCondition != null && smsCondition.getType().equals(SmsEditConstant.CONDITION_TYPE_1)) {
                phoneToSend = smsLogService.searchPhones(smsCondition, request);
                smsJobCondition.setPhones(phoneToSend);
            } else {
                //暂时只支持营销类
                throw new HjException(ResultCode.CONDITION_NOT_EXIST);
            }

        }
        smsJobConditionService.insertSelective(smsJobCondition);
        SystemScheduleJob systemScheduleJob = new SystemScheduleJob();
        systemScheduleJob.setJobName("短信定时任务_" + IdUtil.simpleUUID());
        systemScheduleJob.setBeanClass("SmsJobTask");
        systemScheduleJob.setCronExpression(request.getCronExpression());
        systemScheduleJob.setMethodName("groupSendSmsJson");
        systemScheduleJob.setIsConcurrent(JobConcurrentEnum.CONCURRENT_NOT.getCode());
        systemScheduleJob.setDescription("短信定时任务");
        systemScheduleJob.setJobStatus(JobRunStatusEnum.STATUS_RUNNING.getCode());
        systemScheduleJob.setJobGroup(JobGroupEnum.SMS_TIMING_SEND.getCode());
        systemScheduleJob.setExtendId(smsJobCondition.getId());
        systemScheduleJob.setCreateAdminId(request.getAoAdmin().getId());
        systemScheduleJobService.saveJob(systemScheduleJob);
        return null;
    }

    @Override
    public Integer updateTimingSendJob(AOSmsUpdateTimingSendRequest request) throws SchedulerException {
        SystemScheduleJob systemScheduleJob = this.selectByPrimaryKey(request.getJobId());
        SystemScheduleJob systemScheduleJob4Update = new SystemScheduleJob();
        systemScheduleJob4Update.setId(request.getJobId());
        quartzManager.updateJobCron(systemScheduleJob);
        systemScheduleJob4Update.setCronExpression(request.getCronExpression());
        if(request.getChannelId() != null && request.getChannelId() != 0 ){
            SmsJobCondition smsJobCondition = new SmsJobCondition();
            smsJobCondition.setId(systemScheduleJob.getExtendId());
            smsJobCondition.setChannelId(request.getChannelId());
            smsJobConditionService.updateByPrimaryKeySelective(smsJobCondition);
        }
        return systemScheduleJobService.updateByPrimaryKeySelective(systemScheduleJob4Update);
    }

    @Override
    public Integer stopSchedule(AOSmsStopScheduleRequest request) throws SchedulerException {
        SystemScheduleJob systemScheduleJob = new SystemScheduleJob();
        SystemScheduleJob systemScheduleJobToStop = this.selectByPrimaryKey(request.getJobId());
        quartzManager.deleteJob(systemScheduleJobToStop);
        systemScheduleJob.setId(request.getJobId());
        systemScheduleJob.setJobStatus(JobRunStatusEnum.STATUS_NOT_RUNNING.getCode());
        return this.updateByPrimaryKeySelective(systemScheduleJob);
    }
}
