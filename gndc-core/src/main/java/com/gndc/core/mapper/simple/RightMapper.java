package com.gndc.core.mapper.simple;


import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.model.Right;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RightMapper extends MyMapper<Right, Integer> {

    /**
     * @Description
     * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
     */
//    List<Right> selectAllRight();
}