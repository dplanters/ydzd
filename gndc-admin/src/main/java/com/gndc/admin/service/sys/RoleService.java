package com.gndc.admin.service.sys;

import com.gndc.common.service.BaseService;
import com.gndc.admin.api.admin.sys.AORoleAddRequest;
import com.gndc.admin.api.admin.sys.AORoleModifyRequest;
import com.gndc.common.model.Role;

public interface RoleService extends BaseService<Role, Integer> {

    /**
     * 运营后台-添加角色
     * @param request
     * @return
     */
    Integer addRole(AORoleAddRequest request);

    /**
     * 运营后台-修改角色
     * @param request
     * @return
     */
    Integer modifyRole(AORoleModifyRequest request);
}
