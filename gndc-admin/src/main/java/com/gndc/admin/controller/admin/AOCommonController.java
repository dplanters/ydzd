package com.gndc.admin.controller.admin;

import com.gndc.common.api.ResponseMessage;
import com.gndc.admin.api.partner.common.APAllPartnerRequest;
import com.gndc.common.model.Area;
import com.gndc.common.model.Partner;
import com.gndc.admin.service.area.AreaService;
import com.gndc.admin.service.partner.PartnerService;
import com.gndc.admin.service.sys.SystemOptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/admin/common")
public class AOCommonController {

    @Autowired
    private PartnerService partnerService;
    @Autowired
    private AreaService areaService;
    @Autowired
    private SystemOptionService systemOptionService;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 获取所有机构
     * @param request
     * @return
     */
    @RequestMapping(value = "/getAllPartner")
    public ResponseMessage<List<Partner>> getAllPartner(@Validated @RequestBody APAllPartnerRequest request) {
        ResponseMessage<List<Partner>> response = new ResponseMessage<>();

        List<Partner> partners = partnerService.selectAll();
        response.setData(partners);

        return response;
    }


    /**
     * 获取所有城市
     * @return
     */
    @RequestMapping(value = "/getAllArea")
    public ResponseMessage<List<Area>> getAllArea() {
        ResponseMessage<List<Area>> response = new ResponseMessage<>();
        List<Area> areas = areaService.selectAll();
        response.setData(areas);
        return response;
    }

}
