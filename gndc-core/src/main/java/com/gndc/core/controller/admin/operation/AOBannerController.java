package com.gndc.core.controller.admin.operation;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gndc.common.enums.common.DelEnum;
import com.gndc.common.enums.common.OnlineStatusEnum;
import com.gndc.core.api.admin.operation.*;
import com.gndc.core.api.common.ResponseMessage;
import com.gndc.core.mappers.BannerMapping;
import com.gndc.core.model.Banner;
import com.gndc.core.service.adverts.BannerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.weekend.Weekend;

import java.util.List;

@RestController
@RequestMapping("/admin/operation/banner")
@Slf4j
public class AOBannerController {

    @Autowired
    private BannerService bannerService;

    @PostMapping("/addBanner")
    public ResponseMessage<Integer> addBanner(@Validated @RequestBody AOBannerAddRequest request) {
        ResponseMessage<Integer> response = new ResponseMessage<>();
        Banner banner = BannerMapping.INSTANCE.conver(request);

        Weekend<Banner> weekend = Weekend.of(Banner.class);
        weekend.orderBy("position").desc();
        List<Banner> banners = bannerService.selectByExample(weekend);
        if (CollUtil.isNotEmpty(banners)) {
            banner.setPosition((byte) (banners.get(0).getPosition() + 1));
        } else {
            banner.setPosition((byte) 1);
        }
        bannerService.insertSelective(banner);
        response.setData(banner.getId());
        return response;
    }

    @PostMapping("/sort")
    public ResponseMessage<Boolean> sort(@Validated @RequestBody AOBannerSortRequest request) {
        ResponseMessage<Boolean> response = new ResponseMessage<>();
        bannerService.updateByPrimaryKeySelective(request.getOne());
        bannerService.updateByPrimaryKeySelective(request.getTwo());
        response.setData(true);
        return response;
    }

    @PostMapping("/modifyBanner")
    public ResponseMessage<Integer> modifyBanner(@Validated @RequestBody AOBannerModifyRequest request) {
        ResponseMessage<Integer> response = new ResponseMessage<>();
        Banner banner = BannerMapping.INSTANCE.conver(request);
        bannerService.updateByPrimaryKeySelective(banner);
        response.setData(banner.getId());
        return response;
    }

    @PostMapping("/bannerList")
    public ResponseMessage<List<Banner>> bannerList(@Validated @RequestBody AOBannerListRequest request) {
        ResponseMessage<List<Banner>> response = new ResponseMessage<>();
        List<Banner> banners = bannerService.bannerList(request);
        PageInfo<Banner> pageInfo = new PageInfo<>(banners);
        response.setData(banners);
        response.setPage(pageInfo);
        return response;
    }

    @PostMapping("/deleteBanner")
    public ResponseMessage<Boolean> deleteBanner(@Validated @RequestBody AOBannerDeleteRequest request) {
        ResponseMessage<Boolean> response = new ResponseMessage<>();
        Banner banner = new Banner();
        banner.setId(request.getId());
        banner.setIsDel(DelEnum.IS_DEL.getCode());
        bannerService.updateByPrimaryKeySelective(banner);
        response.setData(true);
        return response;
    }

    @PostMapping("/offline")
    public ResponseMessage<Integer> offline(@Validated @RequestBody AOBannerOfflineRequest request) {
        ResponseMessage<Integer> response = new ResponseMessage<>();
        Banner banner = new Banner();
        Integer id = request.getId();
        banner.setId(id);
        banner.setStatus(OnlineStatusEnum.OFF_LINE.getCode());
        bannerService.updateByPrimaryKeySelective(banner);
        request.setId(id);
        return response;
    }

    @PostMapping("/online")
    public ResponseMessage<Integer> online(@Validated @RequestBody AOBannerOnlineRequest request) {
        ResponseMessage<Integer> response = new ResponseMessage<>();
        Banner banner = new Banner();
        Integer id = request.getId();
        banner.setId(id);
        banner.setStatus(OnlineStatusEnum.ONLINE.getCode());
        bannerService.updateByPrimaryKeySelective(banner);
        request.setId(id);
        return response;
    }
}
