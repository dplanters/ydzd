package com.gndc.admin.service.account;

import com.gndc.common.model.Admin;

public interface AccountService {

    /**
     * 密码校验
     */
    Boolean passwordCheck(Admin admin, String password);

}
