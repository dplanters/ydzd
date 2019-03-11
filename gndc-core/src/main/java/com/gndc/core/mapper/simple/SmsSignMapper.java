package com.gndc.core.mapper.simple;

import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.model.SmsSign;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SmsSignMapper extends MyMapper<SmsSign, Integer> {
}