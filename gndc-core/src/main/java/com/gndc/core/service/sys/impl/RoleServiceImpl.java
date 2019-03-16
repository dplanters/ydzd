package com.gndc.core.service.sys.impl;

import cn.hutool.core.util.StrUtil;
import com.gndc.common.enums.ResultCode;
import com.gndc.common.exception.HjException;
import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.core.api.admin.sys.AORoleAddModifyRequest;
import com.gndc.core.mapper.simple.RoleMapper;
import com.gndc.core.mapper.simple.RoleRightMapper;
import com.gndc.core.model.Role;
import com.gndc.core.model.RoleRight;
import com.gndc.core.service.sys.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer addRole(AORoleAddModifyRequest request) {
        String roleName = request.getRoleName();

        Integer id = request.getId();
        int affectedRow = 0;
        int affectedRows = 0;
        Role role = new Role();
        List<Integer> rightIds = request.getRightIds();
        List<RoleRight> roleRights = new ArrayList<>(rightIds.size());
        if (id == null) {
            //新增
            Role originalRole = roleMapper.selectOneByProperty("roleName", roleName);

            if (originalRole != null) {
                String msg = StrUtil.format("{} 已经存在", roleName);
                logger.warn(msg);
                throw new HjException(ResultCode.ROLENAME_EXISTS, msg);
            }

            role.setRoleName(roleName);
            role.setCreateAdminId(1);
            role.setUpdateAdminId(1);
            affectedRow = roleMapper.insertSelective(role);

            for (Integer rightId : rightIds) {
                RoleRight roleRight = new RoleRight();
                roleRight.setRoleId(role.getId());
                roleRight.setRightId(rightId);
                roleRight.setUpdateAdminId(1);
                Date now = new Date();
                roleRight.setCreateTime(now);
                roleRight.setUpdateTime(now);
                roleRights.add(roleRight);
            }
            affectedRows = roleRightMapper.insertList(roleRights);
        } else {
            //修改
            role.setId(id);
            role.setRoleName(request.getRoleName());

            affectedRow = roleMapper.updateByPrimaryKeySelective(role);

            //删除旧的权限
            Weekend<RoleRight> weekend = Weekend.of(RoleRight.class);
            weekend.weekendCriteria()
                    .andEqualTo(RoleRight::getRoleId, id);
            roleRightMapper.deleteByExample(weekend);

            for (Integer rightId : rightIds) {
                RoleRight roleRight = new RoleRight();
                roleRight.setRoleId(role.getId());
                roleRight.setRightId(rightId);
                roleRight.setUpdateAdminId(1);
                Date now = new Date();
                roleRight.setCreateTime(now);
                roleRight.setUpdateTime(now);
                roleRights.add(roleRight);
            }
            affectedRows = roleRightMapper.insertList(roleRights);
        }
        return role.getId();
    }
}
