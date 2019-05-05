package com.gndc.open.service.impl;

import com.gndc.common.enums.partner.PartnerApiTypeEnum;
import com.gndc.common.mapper.PartnerApiMapper;
import com.gndc.common.model.PartnerApi;
import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.open.service.PartnerApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PartnerApiServiceImpl extends BaseServiceImpl<PartnerApi, Integer> implements PartnerApiService {

    @Autowired
    private PartnerApiMapper partnerApiMapper;

    @Override
    public PartnerApi getPartnerApi(Integer partnerId, PartnerApiTypeEnum partnerApiTypeEnum) {
        PartnerApi partnerApi = new PartnerApi()
                .setPartnerId(partnerId)
                .setApiType(partnerApiTypeEnum.getCode());
        return partnerApiMapper.selectOne(partnerApi);
    }
}
