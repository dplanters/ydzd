package com.gndc.open.service.impl;

import com.gndc.common.mapper.PartnerMapper;
import com.gndc.common.model.Partner;
import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.open.service.PartnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class PartnerServiceImpl extends BaseServiceImpl<Partner, Integer> implements PartnerService {

    @Resource
    private PartnerMapper partnerMapper;

}
