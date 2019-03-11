package com.gndc.core.service.simple.impl;

import cn.hutool.core.util.RandomUtil;
import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.core.exception.LoginFailException;
import com.gndc.core.service.simple.UserService;
import com.gndc.core.dto.LoginInfoDTO;
import com.gndc.core.mapper.simple.UserModelMapper;
import com.gndc.core.mapping.UserModelMapping;
import com.gndc.core.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author 景凯辉
 * @date 2018/11/9
 * @mail kaihuijing@gmail.com
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends BaseServiceImpl<UserModel, Integer> implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserModelMapper userModelMapper;

}
