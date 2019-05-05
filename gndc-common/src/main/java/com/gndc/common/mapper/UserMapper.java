package com.gndc.common.mapper;


import com.gndc.common.model.User;
import com.gndc.common.mybatis.MyMapper;

public interface UserMapper extends MyMapper<User, Integer> {
    int updatePassword(User user);

//    List<AOUserDetailResponse> selectUserEventsDetail(@Param("query") AOUserListRequest request);
}