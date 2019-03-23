package com.gndc.core.service.account;

import com.gndc.common.service.BaseService;
import com.gndc.core.api.admin.sys.AOAdminListRequest;
import com.gndc.core.model.Admin;

import java.util.List;

public interface AdminService extends BaseService<Admin, Integer> {

    /**
     * 运营后台-账号列表
     * @param request
     * @return
     */
    List<Admin> adminList(AOAdminListRequest request);
}
