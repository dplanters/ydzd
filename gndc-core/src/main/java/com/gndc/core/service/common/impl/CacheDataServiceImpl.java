package com.gndc.core.service.common.impl;

import com.gndc.common.constant.CacheConstant;
import com.gndc.core.mapper.simple.RightMapper;
import com.gndc.core.mapper.simple.RoleMapper;
import com.gndc.core.mapper.simple.RoleRightMapper;
import com.gndc.core.model.Right;
import com.gndc.core.model.Role;
import com.gndc.core.model.RoleRight;
import com.gndc.core.service.common.CacheDataService;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;

@Service
@Getter
public class CacheDataServiceImpl implements CacheDataService {
    private static final Logger logger = LoggerFactory.getLogger(CacheDataServiceImpl.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RightMapper rightMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleRightMapper roleRightMapper;

    @PostConstruct
    private void init() {
        //加载所有角色
        List<Role> roles = roleMapper.selectByExample(null);
        for (Role role : roles) {
            redisTemplate.opsForHash().put(CacheConstant.KEY_ALL_ROLE, role.getId(), role);
        }
        //加载所有权限
        List<Right> rights = rightMapper.selectByExample(null);
        for (Right right : rights) {
            redisTemplate.opsForHash().put(CacheConstant.KEY_ALL_RIGHT, right.getId(), right);
        }
        //加载所有角色权限
        List<RoleRight> roleRights = roleRightMapper.selectByExample(null);
        for (RoleRight roleRight : roleRights) {
            redisTemplate.opsForHash().put(CacheConstant.KEY_ALL_ROLE_RIGHT, roleRight.getId(), roleRight);
        }
    }

}
