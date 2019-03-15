package com.gndc.core.service.common.impl;

import com.gndc.core.mapper.simple.RightMapper;
import com.gndc.core.mapper.simple.RoleMapper;
import com.gndc.core.mapper.simple.RoleRightMapper;
import com.gndc.core.model.Right;
import com.gndc.core.model.Role;
import com.gndc.core.model.RoleRight;
import com.gndc.core.service.common.CacheDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CacheDataServiceImpl implements CacheDataService {
    private static final Logger logger = LoggerFactory.getLogger(CacheDataServiceImpl.class);

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    private Map<Integer, Role> roleMap = new HashMap<>();

    private Map<Integer, RoleRight> roleRightMap = new HashMap<>();

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
            roleMap.put(role.getId(), role);
        }

//        redisTemplate;
        //加载所有权限
        List<RoleRight> roleRights = roleRightMapper.selectByExample(null);
        for (RoleRight roleRight : roleRights) {
            roleRightMap.put(roleRight.getId(), roleRight);
        }
    }

}
