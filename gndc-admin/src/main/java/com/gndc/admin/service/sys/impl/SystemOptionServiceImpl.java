package com.gndc.admin.service.sys.impl;

import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.admin.api.partner.common.APPayeeListRequest;
import com.gndc.common.mapper.SystemOptionMapper;
import com.gndc.common.model.SystemOption;
import com.gndc.admin.service.sys.SystemOptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class SystemOptionServiceImpl extends BaseServiceImpl<SystemOption, Integer> implements SystemOptionService {

    @Autowired
    private SystemOptionMapper systemOptionMapper;

    @Override
    public List<String> payeeList(APPayeeListRequest request) {
        SystemOption systemOption = systemOptionMapper.selectOneByProperty(SystemOption::getOptionKey, "PARTNER_PAYEE_LIST");
        return Arrays.asList(systemOption.getOptionValue().split(";"));
    }
}
