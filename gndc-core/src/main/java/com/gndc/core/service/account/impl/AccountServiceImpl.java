package com.gndc.core.service.account.impl;

import com.gndc.core.mapper.simple.AdminMapper;
import com.gndc.core.model.Admin;
import com.gndc.core.service.account.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;

@Service
public class AccountServiceImpl implements AccountService {
    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AdminMapper adminMapper;


    @Override
    public Admin login(String name, String password) {
        Weekend<Admin> weekend = Weekend.of(Admin.class);
        weekend.weekendCriteria()
                .andEqualTo(Admin::getName, name)
                .andEqualTo(Admin::getPassword, password);

        Admin admin = adminMapper.selectOneByExample(weekend);
        return admin;
    }
}
