package com.gndc.core.service.partner.impl;

import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.core.model.PartnerApi;
import com.gndc.core.service.partner.PartnerApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PartnerApiServiceImpl extends BaseServiceImpl<PartnerApi, Integer> implements PartnerApiService {

    private static final Logger logger = LoggerFactory.getLogger(PartnerApiServiceImpl.class);


}
