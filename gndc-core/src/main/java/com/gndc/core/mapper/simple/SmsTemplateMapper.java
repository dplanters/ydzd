package com.gndc.core.mapper.simple;

import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.model.SmsTemplate;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SmsTemplateMapper extends MyMapper<SmsTemplate, Integer> {
}