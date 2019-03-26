package com.gndc.core.service.partner.impl;

import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.core.api.partner.PartnerContactAddRequest;
import com.gndc.core.mapper.simple.PartnerContactMapper;
import com.gndc.core.model.PartnerContact;
import com.gndc.core.service.partner.PartnerContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jingkaihui
 * @date 2019/2/25
 */
@Service
public class PartnerContactServiceImpl extends BaseServiceImpl<PartnerContact, Integer> implements PartnerContactService {

    private static final Logger logger = LoggerFactory.getLogger(PartnerContactServiceImpl.class);
    @Resource
    private PartnerContactMapper partnerContactMapper;

    @Override
    public Boolean addPartnerContact(PartnerContactAddRequest request) {
        PartnerContact partnerContact = new PartnerContact();

        BeanUtils.copyProperties(request, partnerContact);

        partnerContact.setPartnerId(request.getApAdmin().getPartnerId());
        int affected = partnerContactMapper.insertSelective(partnerContact);
        return affected == 1;
    }
}
