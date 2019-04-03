package com.gndc.core.quartz.util;

import cn.hutool.core.util.StrUtil;
import com.gndc.common.constant.SmsEditConstant;
import com.gndc.common.enums.ResultCode;
import com.gndc.common.enums.common.StatusEnum;
import com.gndc.common.enums.sms.SmsChannelEnum;
import com.gndc.common.exception.HjException;
import com.gndc.common.utils.BeanFactoryUtil;
import com.gndc.core.model.*;
import com.gndc.core.service.sms.SmsJobConditionService;
import com.gndc.core.service.sms.SmsSignService;
import com.gndc.core.service.sms.SmsTemplateService;
import lombok.extern.slf4j.Slf4j;
import tk.mybatis.mapper.weekend.Weekend;

import java.lang.reflect.Method;
import java.util.List;


@Slf4j
public class TaskUtils {


    /**
     * 通过反射调用scheduleJob中定义的方法
     *
     * @param scheduleJob
     */
    public static void invokeMethod(SystemScheduleJob scheduleJob) {
        if (scheduleJob == null) {
            return;
        }
        Object object = null;
        Class<?> clazz;
        try {
            clazz = Class.forName(scheduleJob.getBeanClass());
            object = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new HjException(ResultCode.SYSTEM_BUSY, e.getMessage());
        }
        if (object == null) {
            log.error("任务名称 = [" + scheduleJob.getJobName() + "]---------------未启动成功，请检查是否配置正确！！！");
            return;
        }
        clazz = object.getClass();
        Method method = null;
        try {
            method = clazz.getDeclaredMethod(scheduleJob.getMethodName(), String.class, String.class, String.class, SmsGroupLog.class);
        } catch (NoSuchMethodException e) {
            log.error("任务名称 = [" + scheduleJob.getJobName() + "]---------------未启动成功，方法名设置错误！！！");
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        if (method != null) {
            try {

                Integer extendId = scheduleJob.getExtendId();
                if (extendId == null || extendId == 0) {
                    method.invoke(object);
                } else {
                    /**
                     *
                     *
                     * 该方法要是改动，com.gndc.core.controller.admin.sms.AOSmsController.realTimeSend()也需要同步改动
                     *
                     *
                     */
                    //获取bean
                    SmsJobConditionService smsJobConditionService = BeanFactoryUtil.getBean(SmsJobConditionService.class);
                    SmsTemplateService smsTemplateService = BeanFactoryUtil.getBean(SmsTemplateService.class);
                    SmsSignService smsSignService = BeanFactoryUtil.getBean(SmsSignService.class);

                    SmsJobCondition smsJobCondition = smsJobConditionService.selectByPrimaryKey(extendId);
                    Integer templateId = smsJobCondition.getTemplateId();
                    SmsTemplate smsTemplate = smsTemplateService.selectByPrimaryKey(templateId);
                    String signIds = smsJobCondition.getSignIds();
                    if (StrUtil.isNotBlank(signIds)) {
                        Weekend<SmsSign> weekend = Weekend.of(SmsSign.class);
                        weekend.selectProperties("id", "name");
                        weekend.weekendCriteria().andEqualTo(SmsSign::getStatus, StatusEnum.NORMAL.getCode());
                        List<SmsSign> smsSigns = smsSignService.selectByExample(weekend);

                        StringBuffer signName = new StringBuffer();
                        String message = "";
                        String[] signIdArr = signIds.split(",");
                        for (int i = 0; i < signIdArr.length; i++) {
                            for (SmsSign smsSignTemp : smsSigns) {
                                if (smsSignTemp.getId().equals(Integer.parseInt(signIdArr[i]))) {
                                    message = smsSignTemp.getName() + smsTemplate.getContent();
                                    SmsGroupLog smsGroupLog = new SmsGroupLog();
                                    smsGroupLog.setPhone(smsJobCondition.getPhones());
                                    smsGroupLog.setMessage(message);
                                    smsGroupLog.setChannelId(smsJobCondition.getChannelId());
                                    smsGroupLog.setConditionId(extendId);
                                    smsGroupLog.setSendType(SmsEditConstant.SEND_TYPE_1);
                                    smsGroupLog.setSignId(smsSignTemp.getId());
                                    smsGroupLog.setPhoneCount(smsJobCondition.getPhones().split(",").length);
                                    //通道
                                    String channel = "";
                                    //创蓝
                                    if (smsJobCondition.getChannelId().equals(SmsEditConstant.CHANNEL_ID_1)) {
                                        channel = SmsChannelEnum.CHUANGLAN.getCode();
                                    }
                                    //大汉三通
                                    if (smsJobCondition.getChannelId().equals(SmsEditConstant.CHANNEL_ID_2)) {
//                        channel = SmsChannelEnum.CHUANGLAN.getCode();
                                    }
                                    method.invoke(object, channel, smsJobCondition.getPhones(), message, smsGroupLog);
                                }
                            }
                        }

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new HjException(ResultCode.SYSTEM_BUSY, e.getMessage());
            }
        }
    }
}
