package com.gndc.core.service.sys.impl;

import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.core.mapper.simple.RoleMapper;
import com.gndc.core.mapper.simple.RoleRightMapper;
import com.gndc.core.model.RoleRight;
import com.gndc.core.service.sys.RoleRightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleRightServiceImpl extends BaseServiceImpl<RoleRight, Integer> implements RoleRightService {

    private static final Logger logger = LoggerFactory.getLogger(RoleRightServiceImpl.class);

    @Autowired
    private RoleRightMapper roleRightMapper;

    @Override
    public List<Integer> getRightIds(Integer roleId) {
        RoleRight roleRight = new RoleRight();
        roleRight.setRoleId(roleId);

        List<RoleRight> roleRights = roleRightMapper.select(roleRight);
        List<Integer> rightIds = new ArrayList<>(roleRights.size());
        roleRights.forEach(r -> {
            rightIds.add(r.getRightId());
        });

        return rightIds;
    }
}
