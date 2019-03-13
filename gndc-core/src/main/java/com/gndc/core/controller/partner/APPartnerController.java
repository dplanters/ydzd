package com.gndc.core.controller.partner;

import com.gndc.common.api.ResponseMessage;
import com.gndc.core.api.partner.finance.account.APPartnerInfoRequest;
import com.gndc.core.api.partner.finance.account.APPartnerInfoResponse;
import com.gndc.core.service.partner.PartnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/partner")
public class APPartnerController {

    private static final Logger logger = LoggerFactory.getLogger(APPartnerController.class);

    @Autowired
    private PartnerService partnerService;

    @RequestMapping(value = "/finance/account/getPartnerInfo")
    public ResponseMessage<APPartnerInfoResponse> getPartner(@Validated @RequestBody APPartnerInfoRequest request) {
        ResponseMessage<APPartnerInfoResponse> response = new ResponseMessage<>();

        APPartnerInfoResponse partnerInfo = partnerService.getPartner(request);

        response.setData(partnerInfo);

        return response;
    }
}
