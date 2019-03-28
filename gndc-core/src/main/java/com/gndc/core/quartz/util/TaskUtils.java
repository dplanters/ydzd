package com.gndc.core.quartz.util;

import com.gndc.common.enums.ResultCode;
import com.gndc.common.exception.HjException;
import com.gndc.core.model.SystemScheduleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;


public class TaskUtils {
    public final static Logger log = LoggerFactory.getLogger(TaskUtils.class);

	/**
	 * 通过反射调用scheduleJob中定义的方法
	 * 
	 * @param scheduleJob
	 */
	public static void invokeMethod(SystemScheduleJob scheduleJob) {
		Object object = null;
		Class<?> clazz;
		try {
			clazz = Class.forName(scheduleJob.getBeanClass());
			object = clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new HjException(ResultCode.SYSTEM_BUSY,e.getMessage());
		}
		if (object == null) {
			log.error("任务名称 = [" + scheduleJob.getJobName() + "]---------------未启动成功，请检查是否配置正确！！！");
			return;
		}
		clazz = object.getClass();
		Method method = null;
		try {
			method = clazz.getDeclaredMethod(scheduleJob.getMethodName());
		} catch (NoSuchMethodException e) {
			log.error("任务名称 = [" + scheduleJob.getJobName() + "]---------------未启动成功，方法名设置错误！！！");
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		if (method != null) {
			try {
				method.invoke(object);
			} catch (Exception e) {
				throw new HjException(ResultCode.SYSTEM_BUSY,e.getMessage());
			}
		}
	}
}
