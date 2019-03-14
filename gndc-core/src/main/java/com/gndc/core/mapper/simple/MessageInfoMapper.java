package com.gndc.core.mapper.simple;

import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.model.MessageInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface MessageInfoMapper extends MyMapper<MessageInfo, Integer> {

}