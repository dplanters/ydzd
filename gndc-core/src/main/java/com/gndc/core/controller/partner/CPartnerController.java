package com.gndc.core.controller.partner;

import com.gndc.common.api.ResponseMessage;
import com.gndc.core.api.partner.common.APAllPartnerRequest;
import com.gndc.core.model.Partner;
import com.gndc.core.service.partner.PartnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/partner/common")
public class CPartnerController {

    private static final Logger logger = LoggerFactory.getLogger(CPartnerController.class);

    @Autowired
    private PartnerService partnerService;

    @RequestMapping(value = "/getAllPartner")
    public ResponseMessage<List<Partner>> getAllPartner(@RequestBody APAllPartnerRequest request) {
        ResponseMessage<List<Partner>> response = new ResponseMessage<>();

        List<Partner> partners = partnerService.selectAll();
        response.setData(partners);

        return response;
    }
}
