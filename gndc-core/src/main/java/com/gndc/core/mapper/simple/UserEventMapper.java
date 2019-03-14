package com.gndc.core.mapper.simple;

import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.model.UserEvent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface UserEventMapper extends MyMapper<UserEvent, Integer> {

    Integer selectUVCount(@Param("userId") Integer userId, @Param("productId") Integer productId, @Param("beginDate") Date beginDate, @Param("endDate") Date endDate);
}