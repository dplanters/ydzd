package com.gndc.core.service.sys.impl;

import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.core.mapper.simple.RightMapper;
import com.gndc.core.mapper.simple.RoleMapper;
import com.gndc.core.model.Right;
import com.gndc.core.service.sys.RightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RightServiceImpl extends BaseServiceImpl<Right, Integer> implements RightService {

    private static final Logger logger = LoggerFactory.getLogger(RightServiceImpl.class);

    @Autowired
    private RightMapper rightMapper;

}
