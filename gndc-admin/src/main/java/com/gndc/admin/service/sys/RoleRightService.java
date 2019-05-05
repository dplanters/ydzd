package com.gndc.admin.service.sys;

import com.gndc.common.service.BaseService;
import com.gndc.common.model.RoleRight;

import java.util.List;

public interface RoleRightService extends BaseService<RoleRight, Integer> {

    /**
     * 根据角色id获取权限id集合
     * @param roleId
     * @return
     */
    List<Integer> getRightIds(Integer roleId);
}
