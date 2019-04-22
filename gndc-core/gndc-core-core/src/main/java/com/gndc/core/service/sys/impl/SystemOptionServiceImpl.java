package com.gndc.core.service.sys.impl;

import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.core.api.partner.common.APPayeeListRequest;
import com.gndc.core.mapper.SystemOptionMapper;
import com.gndc.core.model.SystemOption;
import com.gndc.core.service.sys.SystemOptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SystemOptionServiceImpl extends BaseServiceImpl<SystemOption, Integer> implements SystemOptionService {

    private static final Logger logger = LoggerFactory.getLogger(SystemOptionServiceImpl.class);

    @Autowired
    private SystemOptionMapper systemOptionMapper;

    @Override
    public List<String> payeeList(APPayeeListRequest request) {
        SystemOption systemOption = systemOptionMapper.selectOneByProperty(SystemOption::getOptionKey, "PARTNER_PAYEE_LIST");
        return Arrays.asList(systemOption.getOptionValue().split(";"));
    }
}
