package com.gndc.core.controller.admin.partner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gndc.common.api.ResponseMessage;
import com.gndc.common.constant.CacheConstant;
import com.gndc.common.enums.common.StatusEnum;
import com.gndc.core.api.admin.partner.*;
import com.gndc.core.mappers.PartnerMapping;
import com.gndc.core.model.Partner;
import com.gndc.core.service.partner.PartnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.weekend.Weekend;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/admin/partner")
public class AOPartnerController {
    @Autowired
    private PartnerMapping partnerMapping;

    @Autowired
    private PartnerService partnerService;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 添加商户信息
     * @param request
     * @return
     */
    @PostMapping("/addPartner")
    public ResponseMessage<Integer> addPartner(@Validated @RequestBody AOPartnerAddRequest request) {
        ResponseMessage<Integer> response = new ResponseMessage<>();
        Partner partner = partnerMapping.convert(request);
        partnerService.insertSelective(partner);
        redisTemplate.opsForHash().put(CacheConstant.KEY_ALL_PARTNER_LIST,partner.getAppId(),partner);
        response.setData(partner.getId());
        return response;
    }

    /**
     * 修改商户信息
     * @param request
     * @return
     */
    @PostMapping("/modifyPartner")
    public ResponseMessage<Integer> modifyPartner(@Validated @RequestBody AOPartnerModifyRequest request) {
        ResponseMessage<Integer> response = new ResponseMessage<>();
        Partner partner = partnerMapping.convert(request);
        partnerService.updateByPrimaryKeySelective(partner);
        response.setData(partner.getId());
        redisTemplate.opsForHash().put(CacheConstant.KEY_ALL_PARTNER_LIST,partner.getAppId(),partner);
        return response;
    }

    /**
     * 删除商户
     * @param request
     * @return
     */
    @PostMapping("/deletePartner")
    public ResponseMessage<Boolean> deletePartner(@Validated @RequestBody AOPartnerDeleteRequest request) {
        ResponseMessage<Boolean> response = new ResponseMessage<>();
        Partner partner = new Partner().setId(request.getId()).setStatus(StatusEnum.DELETE.getCode());
        partnerService.updateByPrimaryKeySelective(partner);
        response.setData(true);
        redisTemplate.opsForHash().delete(CacheConstant.KEY_ALL_PARTNER_LIST,partner.getAppId(),partner);
        return response;
    }

    /**
     * 获取商户详情
     * @param request
     * @return
     */
    @PostMapping("/detailPartner")
    public ResponseMessage<Partner> detailPartner(@Validated @RequestBody AOPartnerDetailRequest request) {
        ResponseMessage<Partner> response = new ResponseMessage<>();
        Partner partner = partnerService.selectByPrimaryKey(request.getId());
        response.setData(partner);
        return response;
    }

    /**
     * 商户列表
     * @param request
     * @return
     */
    @PostMapping("/partnerList")
    public ResponseMessage<List<Partner>> partnerList(@Validated @RequestBody AOPartnerListRequest request) {
        ResponseMessage<List<Partner>> response = new ResponseMessage<>();
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        Weekend<Partner> weekend = Weekend.of(Partner.class);
        weekend.weekendCriteria()
                .andEqualTo(Partner::getStatus, StatusEnum.NORMAL.getCode());
        List<Partner> partners = partnerService.selectByExample(weekend);
        PageInfo<Partner> pageInfo = new PageInfo<>(partners);
        response.setPage(pageInfo);
        response.setData(partners);
        return response;
    }
}
