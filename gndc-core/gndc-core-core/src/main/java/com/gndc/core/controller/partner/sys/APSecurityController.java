package com.gndc.core.controller.partner.sys;

import com.gndc.common.api.ResponseMessage;
import com.gndc.core.api.partner.sys.APPartnerContactAddRequest;
import com.gndc.core.service.partner.PartnerContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/partner")
public class APSecurityController {

    private static final Logger logger = LoggerFactory.getLogger(APSecurityController.class);

    @Autowired
    private PartnerContactService partnerContactService;

    /**
     * 添加紧急联系人
     * @param request
     * @return
     */
    @PostMapping(value = "/addPartnerContact")
    public ResponseMessage<Boolean> addPartnerContact(@Validated @RequestBody APPartnerContactAddRequest request) {
        ResponseMessage<Boolean> response = new ResponseMessage<>();
        response.setData(partnerContactService.addPartnerContact(request));

        return response;
    }
}
