/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 * 
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.interceptor;

import cn.hutool.core.date.DateUtil;
import com.gndc.common.model.BaseEntity;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.util.Properties;

//@Component
@Intercepts(
		{   @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class}),
			@Signature(type = Executor.class, method = "insert", args = { MappedStatement.class, Object.class})
		})
public class GregorianTimeInterceptor implements Interceptor  {


	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		MappedStatement stmt = (MappedStatement) invocation.getArgs()[0];
		Object param = invocation.getArgs()[1];
		if (stmt == null) {
			return invocation.proceed();
		}

		if (stmt.getSqlCommandType().equals(SqlCommandType.INSERT)) {

			if (param != null && param instanceof BaseEntity) {
				BaseEntity e = (BaseEntity) param;
				e.setCreateTime(DateUtil.date().toJdkDate());
			}
		}

		if (stmt.getSqlCommandType().equals(SqlCommandType.UPDATE)) {
			if (param != null && param instanceof BaseEntity) {
				BaseEntity e = (BaseEntity) param;
				e.setUpdateTime(DateUtil.date().toJdkDate());
			}
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return null;
	}

	@Override
	public void setProperties(Properties properties) {
//		properties = new Properties();
//        properties.setProperty("dialect", "mysql");
	}
}
