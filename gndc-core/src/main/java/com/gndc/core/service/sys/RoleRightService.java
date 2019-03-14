package com.gndc.core.service.sys;

import com.gndc.common.service.BaseService;
import com.gndc.core.model.Right;
import com.gndc.core.model.RoleRight;

import java.util.List;

public interface RoleRightService extends BaseService<RoleRight, Integer> {

    /**
     * 根据角色id获取权限id集合
     * @param roleId
     * @return
     */
    List<Integer> getRightIds(Integer roleId);
}
