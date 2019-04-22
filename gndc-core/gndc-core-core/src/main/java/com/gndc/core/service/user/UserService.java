package com.gndc.core.service.user;

import com.gndc.common.service.BaseService;
import com.gndc.core.api.admin.user.AOUserDetailResponse;
import com.gndc.core.api.admin.user.AOUserListRequest;
import com.gndc.core.model.User;

import java.util.List;


public interface UserService extends BaseService<User, Integer> {
    int updatePassword(User userInfo);

    List<AOUserDetailResponse> selectUserEventsDetail(AOUserListRequest request);
}
