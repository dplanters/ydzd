package com.gndc.admin.service.user;

import com.gndc.common.service.BaseService;
import com.gndc.admin.api.admin.user.AOUserDetailResponse;
import com.gndc.admin.api.admin.user.AOUserListRequest;
import com.gndc.common.model.User;

import java.util.List;


public interface UserService extends BaseService<User, Integer> {
    int updatePassword(User userInfo);

    List<AOUserDetailResponse> selectUserEventsDetail(AOUserListRequest request);
}
