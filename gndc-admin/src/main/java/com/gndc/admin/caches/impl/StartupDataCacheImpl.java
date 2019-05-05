package com.gndc.admin.caches.impl;

import com.gndc.admin.caches.StartupDataCache;
import com.gndc.common.mapper.RightMapper;
import com.gndc.common.mapper.RoleMapper;
import com.gndc.common.mapper.RoleRightMapper;
import com.gndc.admin.mappers.RightInfoDTOMapping;
import com.gndc.admin.service.partner.PartnerApiService;
import com.gndc.admin.service.partner.PartnerService;
import com.gndc.common.constant.CacheConstant;
import com.gndc.common.dto.RightInfoDTO;
import com.gndc.common.enums.common.StatusEnum;
import com.gndc.common.model.*;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Slf4j
@Getter
public class StartupDataCacheImpl implements StartupDataCache {

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
