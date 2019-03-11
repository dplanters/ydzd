package com.gndc.core.mapper.simple;

import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.model.UserModel;
import org.apache.ibatis.annotations.Select;

public interface UserModelMapper extends MyMapper<UserModel, Integer> {

}