package com.gndc.core.mapper.simple;

import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.model.AppException;
import org.apache.ibatis.annotations.Mapper;

public interface AppExceptionMapper extends MyMapper<AppException, Integer> {
}