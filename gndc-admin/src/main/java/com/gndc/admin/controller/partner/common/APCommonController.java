package com.gndc.admin.controller.partner.common;

import com.gndc.common.api.ResponseMessage;
import com.gndc.admin.api.partner.common.APAllPartnerRequest;
import com.gndc.admin.api.partner.common.APPayeeListRequest;
import com.gndc.common.model.Partner;
import com.gndc.admin.service.partner.PartnerService;
import com.gndc.admin.service.sys.SystemOptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/partner/common")
public class APCommonController {

    @Autowired
    private PartnerService partnerService;

    @Autowired
    private SystemOptionService systemOptionService;

    /**
     * 获取所有商户信息
     * @param request
     * @return
     */
    @PostMapping(value = "/getAllPartner")
    public ResponseMessage<List<Partner>> getAllPartner(@Validated @RequestBody APAllPartnerRequest request) {
        ResponseMessage<List<Partner>> response = new ResponseMessage<>();

        List<Partner> partners = partnerService.selectAll();
        response.setData(partners);

        return response;
    }

    /**
     * 获取收款人列表
     * @param request
     * @return
     */
    @PostMapping(value = "/payeeList")
    public ResponseMessage<List<String>> payeeList(@Validated @RequestBody APPayeeListRequest request) {
        ResponseMessage<List<String>> response = new ResponseMessage<>();

        List<String> payeeList = systemOptionService.payeeList(request);
        response.setData(payeeList);

        return response;
    }
}
