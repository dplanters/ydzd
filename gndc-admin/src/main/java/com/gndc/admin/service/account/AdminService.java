package com.gndc.admin.service.account;

import com.gndc.common.service.BaseService;
import com.gndc.admin.api.admin.sys.AOAdminListRequest;
import com.gndc.common.model.Admin;

import java.util.List;

public interface AdminService extends BaseService<Admin, Integer> {

    /**
     * 运营后台-账号列表
     * @param request
     * @return
     */
    List<Admin> adminList(AOAdminListRequest request);
}
