package com.gndc.core.service.user.impl;

import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.core.mapper.simple.UserMapper;
import com.gndc.core.model.User;
import com.gndc.core.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int updatePassword(User userInfo) {
        return userMapper.updatePassword(userInfo);
    }
}
