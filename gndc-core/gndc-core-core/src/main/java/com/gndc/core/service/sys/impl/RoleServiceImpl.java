package com.gndc.core.service.sys.impl;

import cn.hutool.core.util.StrUtil;
import com.gndc.common.constant.CacheConstant;
import com.gndc.common.enums.ResultCode;
import com.gndc.common.exception.HjException;
import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.core.api.admin.sys.AORoleAddRequest;
import com.gndc.core.api.admin.sys.AORoleModifyRequest;
import com.gndc.core.mapper.simple.RoleMapper;
import com.gndc.core.mapper.simple.RoleRightMapper;
import com.gndc.core.model.Role;
import com.gndc.core.model.RoleRight;
import com.gndc.core.service.sys.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.weekend.Weekend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, Integer> implements RoleService {

    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleRightMapper roleRightMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer addRole(AORoleAddRequest request) {
        String roleName = request.getRoleName();

        Role role = new Role();
        List<Integer> rightIds = request.getRightIds();
        List<RoleRight> roleRights = new ArrayList<>(rightIds.size());
        //新增
        Role originalRole = roleMapper.selectOneByProperty(Role::getRoleName, roleName);

        if (originalRole != null) {
            String msg = StrUtil.format("{} 已经存在", roleName);
            logger.warn(msg);
            throw new HjException(ResultCode.ROLENAME_EXISTS);
        }
        role.setPlatform(request.getPlatform());
        role.setRoleName(roleName);
        role.setCreateAdminId(request.getAoAdmin().getId());
        role.setUpdateAdminId(request.getAoAdmin().getId());
        roleMapper.insertSelective(role);
        redisTemplate.opsForHash().put(CacheConstant.KEY_ALL_ROLE, role.getId(), role);

        for (Integer rightId : rightIds) {
            RoleRight roleRight = new RoleRight();
            roleRight.setRoleId(role.getId());
            roleRight.setRightId(rightId);
            roleRight.setUpdateAdminId(request.getAoAdmin().getId());
            Date now = new Date();
            roleRight.setCreateTime(now);
            roleRight.setUpdateTime(now);
            roleRights.add(roleRight);
        }
        roleRightMapper.insertList(roleRights);
        for (RoleRight roleRight : roleRights) {
            redisTemplate.opsForHash().put(CacheConstant.KEY_ALL_ROLE_RIGHT, roleRight.getId(), roleRight);
        }
        return role.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer modifyRole(AORoleModifyRequest request) {
        String roleName = request.getRoleName();

        Integer id = request.getId();
        Role role = new Role();
        List<Integer> newRightIds = request.getRightIds();
            //修改
        role.setId(id);
        role.setRoleName(roleName);

        roleMapper.updateByPrimaryKeySelective(role);

        redisTemplate.opsForHash().put(CacheConstant.KEY_ALL_ROLE, role.getId(), role);

        List<RoleRight> oldRoleRights = roleRightMapper.selectByProperty(RoleRight::getRoleId, id);

        //删除旧的权限
        Weekend<RoleRight> weekend = Weekend.of(RoleRight.class);
        weekend.weekendCriteria()
                .andEqualTo(RoleRight::getRoleId, id);
        roleRightMapper.deleteByExample(weekend);

        //删除缓存中旧权限
        List<Integer> oldRoleRightIds = new ArrayList<>(oldRoleRights.size());

        oldRoleRights.forEach(roleRight -> {
            oldRoleRightIds.add(roleRight.getId());
        });
        redisTemplate.opsForHash().delete(CacheConstant.KEY_ALL_ROLE_RIGHT, oldRoleRightIds);

        List<RoleRight> newRoleRights = new ArrayList<>(newRightIds.size());
        for (Integer rightId : newRightIds) {
            RoleRight roleRight = new RoleRight();
            roleRight.setRoleId(role.getId());
            roleRight.setRightId(rightId);
            roleRight.setUpdateAdminId(request.getAoAdmin().getId());
            Date now = new Date();
            roleRight.setCreateTime(now);
            roleRight.setUpdateTime(now);
            newRoleRights.add(roleRight);
        }
        roleRightMapper.insertList(newRoleRights);
        for (RoleRight roleRight : newRoleRights) {
            redisTemplate.opsForHash().put(CacheConstant.KEY_ALL_ROLE_RIGHT, roleRight.getId(), roleRight);
        }
        return role.getId();
    }
}
