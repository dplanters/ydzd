package com.gndc.admin.controller.provider;

import com.gndc.common.api.ResponseMessage;
import com.gndc.common.model.Partner;
import com.gndc.admin.service.partner.PartnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="jingkaihui@adpanshi.com">jingkaihui</a>
 * @Description
 * @date 2019/4/29
 */
@Slf4j
@RestController
@RequestMapping("/provider/partner")
public class PartnerController {

    @Autowired
    private PartnerService partnerService;

    /**
     * 获取商户详情
     * @return
     */
    @GetMapping("/detail/{partnerId}")
    public ResponseMessage<Partner> detail(@PathVariable("partnerId") Integer partnerId) {
        ResponseMessage<Partner> response = new ResponseMessage<>();
        Partner partner = partnerService.selectByPrimaryKey(partnerId);
        response.setData(partner);
        return response;
    }

}
