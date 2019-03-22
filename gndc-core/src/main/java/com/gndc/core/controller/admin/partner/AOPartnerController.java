package com.gndc.core.controller.admin.partner;

import com.gndc.core.api.admin.partner.*;
import com.gndc.core.api.common.ResponseMessage;
import com.gndc.core.mappers.PartnerMapping;
import com.gndc.core.model.Partner;
import com.gndc.core.service.partner.PartnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/partner")
public class AOPartnerController {

    private static final Logger logger = LoggerFactory.getLogger(AOPartnerController.class);

    @Autowired
    private PartnerService partnerService;

    @PostMapping("/addPartner")
    public ResponseMessage<Integer> addPartner(@Validated @RequestBody AOPartnerAddRequest request) {
        ResponseMessage<Integer> response = new ResponseMessage<>();
        Partner partner = PartnerMapping.INSTANCE.convert(request);
        partnerService.insertSelective(partner);
        response.setData(partner.getId());
        return response;
    }

    @PostMapping("/modifyPartner")
    public ResponseMessage<Integer> modifyPartner(@Validated @RequestBody AOPartnerModifyRequest request) {
        ResponseMessage<Integer> response = new ResponseMessage<>();
        Partner partner = PartnerMapping.INSTANCE.convert(request);
        partnerService.updateByPrimaryKeySelective(partner);
        response.setData(partner.getId());
        return response;
    }

    @PostMapping("/deletePartner")
    public ResponseMessage<Boolean> deletePartner(@Validated @RequestBody AOPartnerDeleteRequest request) {
        ResponseMessage<Boolean> response = new ResponseMessage<>();
        partnerService.deleteByPrimaryKey(request.getId());
        response.setData(true);
        return response;
    }

    @PostMapping("/detailPartner")
    public ResponseMessage<Partner> detailPartner(@Validated @RequestBody AOPartnerDetailRequest request) {
        ResponseMessage<Partner> response = new ResponseMessage<>();
        Partner partner = partnerService.selectByPrimaryKey(request.getId());
        response.setData(partner);
        return response;
    }

    @PostMapping("/partnerList")
    public ResponseMessage<List<Partner>> partnerList(@Validated @RequestBody AOPartnerListRequest request) {
        ResponseMessage<List<Partner>> response = new ResponseMessage<>();
        List<Partner> partners = partnerService.selectAll();
        response.setData(partners);
        return response;
    }
}
