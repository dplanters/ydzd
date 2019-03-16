package com.gndc.core.service.sys;

import com.gndc.common.service.BaseService;
import com.gndc.core.api.admin.sys.AORoleAddModifyRequest;
import com.gndc.core.model.Role;

public interface RoleService extends BaseService<Role, Integer> {

    /**
     * 运营后台-添加角色
     * @param request
     * @return
     */
    Integer addRole(AORoleAddModifyRequest request);

}
