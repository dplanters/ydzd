package com.gndc.core.service.partner.impl;

import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.core.api.partner.sys.APPartnerContactAddRequest;
import com.gndc.core.mapper.PartnerContactMapper;
import com.gndc.core.model.PartnerContact;
import com.gndc.core.service.partner.PartnerContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jingkaihui
 * @date 2019/2/25
 */
@Slf4j
@Service
public class PartnerContactServiceImpl extends BaseServiceImpl<PartnerContact, Integer> implements PartnerContactService {

    @Resource
    private PartnerContactMapper partnerContactMapper;

    @Override
    public Boolean addPartnerContact(APPartnerContactAddRequest request) {
        PartnerContact partnerContact = new PartnerContact();

        BeanUtils.copyProperties(request, partnerContact);

        partnerContact.setPartnerId(request.getApAdmin().getPartnerId());
        int affected = partnerContactMapper.insertSelective(partnerContact);
        return affected == 1;
    }
}
