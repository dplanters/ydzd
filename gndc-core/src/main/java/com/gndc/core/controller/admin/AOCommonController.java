package com.gndc.core.controller.admin;

import com.gndc.core.api.common.ResponseMessage;
import com.gndc.core.api.partner.common.APAllPartnerRequest;
import com.gndc.core.model.Partner;
import com.gndc.core.service.partner.PartnerService;
import com.gndc.core.service.sys.SystemOptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/admin/common")
public class AOCommonController {

    private static final Logger logger = LoggerFactory.getLogger(AOCommonController.class);

    @Autowired
    private PartnerService partnerService;

    @Autowired
    private SystemOptionService systemOptionService;

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @RequestMapping(value = "/getAllPartner")
    public ResponseMessage<List<Partner>> getAllPartner(@Validated @RequestBody APAllPartnerRequest request) {
        ResponseMessage<List<Partner>> response = new ResponseMessage<>();

        List<Partner> partners = partnerService.selectAll();
        response.setData(partners);

        return response;
    }

}
