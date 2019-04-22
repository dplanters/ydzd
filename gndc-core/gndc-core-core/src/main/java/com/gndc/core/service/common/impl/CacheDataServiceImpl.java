package com.gndc.core.service.common.impl;

import com.gndc.common.constant.CacheConstant;
import com.gndc.common.dto.RightInfoDTO;
import com.gndc.common.enums.common.StatusEnum;
import com.gndc.core.mapper.simple.RightMapper;
import com.gndc.core.mapper.simple.RoleMapper;
import com.gndc.core.mapper.simple.RoleRightMapper;
import com.gndc.core.mappers.RightInfoDTOMapping;
import com.gndc.core.model.*;
import com.gndc.core.service.common.CacheDataService;
import com.gndc.core.service.partner.PartnerApiService;
import com.gndc.core.service.partner.PartnerService;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Getter
public class CacheDataServiceImpl implements CacheDataService {
    private static final Logger logger = LoggerFactory.getLogger(CacheDataServiceImpl.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RightInfoDTOMapping rightInfoDTOMapping;

    @Autowired
    private RightMapper rightMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleRightMapper roleRightMapper;

    @Autowired
    private PartnerService partnerService;
    @Autowired
    private PartnerApiService partnerApiService;

    @PostConstruct
    private void init() {
        //加载所有角色
        List<Role> roles = roleMapper.selectByExample(null);
        roles.forEach(role -> redisTemplate.opsForHash().put(CacheConstant.KEY_ALL_ROLE, role.getId(), role));

        //加载所有权限
        List<Right> rights = rightMapper.selectByExample(null);
        rights.forEach(right -> {
            RightInfoDTO rightInfo = rightInfoDTOMapping.convert(right);
            redisTemplate.opsForHash().put(CacheConstant.KEY_ALL_RIGHT, rightInfo.getId(), rightInfo);
        });

        //加载所有角色权限
        List<RoleRight> roleRights = roleRightMapper.selectByExample(null);
        roleRights.forEach(roleRight -> redisTemplate.opsForHash().put(CacheConstant.KEY_ALL_ROLE_RIGHT, roleRight.getId(), roleRight));

        //机构信息加入缓存
        Weekend<Partner> weekend = Weekend.of(Partner.class);
        weekend.weekendCriteria().andEqualTo(Partner::getStatus, StatusEnum.NORMAL.getCode());
        List<Partner> partners = partnerService.selectByExample(weekend);
        partners.forEach(x->{
            redisTemplate.opsForHash().put(CacheConstant.KEY_ALL_PARTNER_LIST,x.getAppId(),x);
        });

        //机构信息加入缓存
        Weekend<PartnerApi> partnerApiWeekend = Weekend.of(PartnerApi.class);
        partnerApiWeekend.weekendCriteria().andEqualTo(PartnerApi::getStatus, StatusEnum.NORMAL.getCode());
        List<PartnerApi> partnerApis = partnerApiService.selectByExample(partnerApiWeekend);
        partnerApis.forEach(x->{
            redisTemplate.opsForHash().put(CacheConstant.KEY_ALL_PARTNER_API_LIST,x.getPartnerId()+":"+x.getApiType(),x);
        });

    }

}
