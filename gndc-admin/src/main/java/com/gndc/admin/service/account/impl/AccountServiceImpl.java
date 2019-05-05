package com.gndc.admin.service.account.impl;

import com.gndc.common.utils.PwdUtil;
import com.gndc.common.mapper.AdminMapper;
import com.gndc.common.model.Admin;
import com.gndc.admin.service.account.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Boolean passwordCheck(Admin admin, String password) {
        Boolean pass = true;
        String originalPassword = PwdUtil.decrypt(password);

        String pwdMd5 = PwdUtil.passwordGenerate(originalPassword, admin.getPasswordSign());

        if (!pwdMd5.equals(admin.getPassword())) {
            pass = false;
        }
        return pass;
    }
}
