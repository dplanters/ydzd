package com.gndc.core.mapper.simple;

import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.model.SmsChannel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SmsChannelMapper extends MyMapper<SmsChannel, Integer> {
}