package com.gndc.core.mapper.simple;

import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.model.SystemStatistic;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SystemStatisticMapper extends MyMapper<SystemStatistic, Integer> {
}