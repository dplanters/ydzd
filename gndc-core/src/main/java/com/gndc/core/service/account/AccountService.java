package com.gndc.core.service.account;

import com.gndc.core.api.admin.account.AOLoginRequest;
import com.gndc.core.model.Admin;

public interface AccountService {

    /**
     * 密码校验
     */
    Boolean passwordCheck(Admin admin, String password);

}
