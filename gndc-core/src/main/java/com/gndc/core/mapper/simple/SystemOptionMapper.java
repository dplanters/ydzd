package com.gndc.core.mapper.simple;

import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.model.SystemOption;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SystemOptionMapper extends MyMapper<SystemOption, Integer> {

    List<SystemOption> selectAllSysOption();
}