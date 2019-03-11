package com.gndc.core.mapper.simple;

import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.model.MessageTemplate;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageTemplateMapper extends MyMapper<MessageTemplate, Integer> {
}