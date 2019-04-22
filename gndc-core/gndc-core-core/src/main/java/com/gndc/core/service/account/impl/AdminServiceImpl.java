package com.gndc.core.service.account.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.gndc.common.enums.common.StatusEnum;
import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.core.api.admin.sys.AOAdminListRequest;
import com.gndc.core.mapper.simple.AdminMapper;
import com.gndc.core.model.Admin;
import com.gndc.core.service.account.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.List;

@Slf4j
@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin, Integer> implements AdminService {

    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Admin> adminList(AOAdminListRequest request) {
        Weekend<Admin> weekend = Weekend.of(Admin.class);
        WeekendCriteria<Admin, Object> weekendCriteria = weekend.weekendCriteria();
        weekendCriteria
                .andEqualTo(Admin::getStatus, StatusEnum.NORMAL.getCode())
                .andEqualTo(Admin::getPlatform, ObjectUtil.defaultIfNull(request.getPlatform(), null))
                .andEqualTo(Admin::getName, StrUtil.isEmpty(request.getName()) ? null : request.getName())
                .andEqualTo(Admin::getLoginName, StrUtil.isEmpty(request.getLoginName()) ? null : request.getLoginName())
                .andEqualTo(Admin::getPhone, StrUtil.isEmpty(request.getPhone()) ? null : request.getPhone())
                .andGreaterThanOrEqualTo(Admin::getCreateTime, ObjectUtil.defaultIfNull(request.getStartDate(), null))
                .andLessThanOrEqualTo(Admin::getCreateTime, ObjectUtil.defaultIfNull(request.getEndDate(), null));
        return adminMapper.selectByExample(weekend);
    }
}
