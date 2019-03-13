package com.gndc.core.controller.partner;

import com.gndc.common.api.ResponseMessage;
import com.gndc.core.api.partner.PartnerContactAddRequest;
import com.gndc.core.service.partner.PartnerContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class APPartnerContactController {

    private static final Logger logger = LoggerFactory.getLogger(APPartnerContactController.class);

    @Autowired
    private PartnerContactService partnerContactService;

    @RequestMapping(value = "/addPartnerContact")
    public ResponseMessage<Boolean> addPartnerContact(@Validated @RequestBody PartnerContactAddRequest request) {
        ResponseMessage<Boolean> response = new ResponseMessage<>();
        response.setData(partnerContactService.addPartnerContact(request));

        return response;
    }
}
