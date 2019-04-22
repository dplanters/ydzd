package com.gndc.core.mapper;


import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.api.admin.user.AOUserDetailResponse;
import com.gndc.core.api.admin.user.AOUserListRequest;
import com.gndc.core.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends MyMapper<User, Integer> {
    int updatePassword(User user);

    List<AOUserDetailResponse> selectUserEventsDetail(@Param("query") AOUserListRequest request);
}