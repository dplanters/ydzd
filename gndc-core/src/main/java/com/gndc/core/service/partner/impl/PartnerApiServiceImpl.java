package com.gndc.core.service.partner.impl;

import com.gndc.common.enums.partner.PartnerAccountLogStatusEnum;
import com.gndc.common.enums.partner.PartnerAccountLogTypeEnum;
import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.core.api.partner.finance.account.APPartnerInfoRequest;
import com.gndc.core.api.partner.finance.account.APPartnerInfoResponse;
import com.gndc.core.mapper.simple.PartnerAccountLogMapper;
import com.gndc.core.mapper.simple.PartnerApiMapper;
import com.gndc.core.mapper.simple.PartnerMapper;
import com.gndc.core.model.Partner;
import com.gndc.core.model.PartnerApi;
import com.gndc.core.service.partner.PartnerApiService;
import com.gndc.core.service.partner.PartnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class PartnerApiServiceImpl extends BaseServiceImpl<PartnerApi, Integer> implements PartnerApiService {

    private static final Logger logger = LoggerFactory.getLogger(PartnerApiServiceImpl.class);


}
