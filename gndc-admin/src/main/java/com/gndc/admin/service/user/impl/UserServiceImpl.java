package com.gndc.admin.service.user.impl;

import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.admin.api.admin.user.AOUserDetailResponse;
import com.gndc.admin.api.admin.user.AOUserListRequest;
import com.gndc.common.mapper.UserMapper;
import com.gndc.common.model.User;
import com.gndc.admin.service.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int updatePassword(User userInfo) {
        return userMapper.updatePassword(userInfo);
    }

    @Override
    public List<AOUserDetailResponse> selectUserEventsDetail(AOUserListRequest request) {
//        return userMapper.selectUserEventsDetail(request);
        return null;
    }
}
