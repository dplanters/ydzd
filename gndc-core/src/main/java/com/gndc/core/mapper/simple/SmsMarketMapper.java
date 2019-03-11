package com.gndc.core.mapper.simple;

import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.model.SmsMarket;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SmsMarketMapper extends MyMapper<SmsMarket, Integer> {
}