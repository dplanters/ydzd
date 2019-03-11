package com.gndc.core.mapper.simple;

import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.model.ProductData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDataMapper extends MyMapper<ProductData, Integer> {

}