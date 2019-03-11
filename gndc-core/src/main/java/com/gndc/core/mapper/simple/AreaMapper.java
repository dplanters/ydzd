package com.gndc.core.mapper.simple;


import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.model.Area;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AreaMapper extends MyMapper<Area, Integer> {

    /**
     * 获取所有地区
     *
     * @return
     * @Description
     */
    List<Area> selectAllArea();
}