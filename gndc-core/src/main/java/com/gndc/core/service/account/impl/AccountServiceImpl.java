package com.gndc.core.service.account.impl;

import cn.hutool.core.util.StrUtil;
import com.gndc.common.api.HjException;
import com.gndc.common.api.ResultCode;
import com.gndc.common.constant.Constant;
import com.gndc.common.enums.admin.AdminType;
import com.gndc.common.enums.common.DelType;
import com.gndc.common.utils.JsonUtil;
import com.gndc.common.utils.MD5Util;
import com.gndc.common.utils.PwdUtil;
import com.gndc.core.api.admin.account.AOLoginRequest;
import com.gndc.core.mapper.simple.AdminMapper;
import com.gndc.core.model.Admin;
import com.gndc.core.service.account.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;

import java.io.Serializable;

@Service
public class AccountServiceImpl implements AccountService {
    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Boolean passwordCheck(Admin admin, String password) {
        Boolean pass = true;
        String passwordDec = PwdUtil.decryptRSA(password);

        String pwdMd5 = MD5Util.getMD5(passwordDec + admin.getPasswordSign()).substring(5, 30);

        if (!pwdMd5.equals(admin.getPassword())) {
            pass = false;
        }
        return pass;
    }
}
