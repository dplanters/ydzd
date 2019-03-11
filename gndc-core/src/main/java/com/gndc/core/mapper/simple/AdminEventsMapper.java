package com.gndc.core.mapper.simple;

import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.model.AdminEvents;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminEventsMapper extends MyMapper<AdminEvents, Integer> {
}