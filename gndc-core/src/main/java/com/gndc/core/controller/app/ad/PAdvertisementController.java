package com.gndc.core.controller.app.ad;

import com.gndc.common.enums.common.OnlineStatusEnum;
import com.gndc.common.api.ResponseMessage;
import com.gndc.common.enums.common.StatusEnum;
import com.gndc.core.api.app.ad.PBannerListRequest;
import com.gndc.core.api.app.ad.POpeningPopupAdvertisementRequest;
import com.gndc.core.model.Advertis;
import com.gndc.core.model.Banner;
import com.gndc.core.service.adverts.AdvertsService;
import com.gndc.core.service.adverts.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.weekend.Weekend;

import java.util.Date;
import java.util.List;

/**
 * 客户端banner轮播图，广告
 */
@RestController
@RequestMapping("/app/ad")
public class PAdvertisementController {

    @Autowired
    private BannerService bannerService;
    @Autowired
    private AdvertsService advertsService;

    /**
     * 轮播图
     *
     * @param bannerListRequest
     * @return
     */
    @PostMapping("/bannerList")
    public ResponseMessage<List<Banner>> bannerList(@Validated @RequestBody PBannerListRequest bannerListRequest) {
        ResponseMessage<List<Banner>> response = new ResponseMessage<>();

        Date currTime = new Date();
        Weekend<Banner> weekend = Weekend.of(Banner.class);
        weekend.selectProperties("link", "imgUrl", "productId");
        weekend.weekendCriteria()
                .andLessThanOrEqualTo(Banner::getBeginTime, currTime)
                .andGreaterThanOrEqualTo(Banner::getEndTime, currTime)
                .andEqualTo(Banner::getBannerStatus, OnlineStatusEnum.ONLINE.getCode())
                .andEqualTo(Banner::getStatus, StatusEnum.NORMAL.getCode());
        weekend.setOrderByClause("position");

        List<Banner> banners = bannerService.selectByExample(weekend);
        if (banners != null && banners.size() > 0) {
            for (Banner temp : banners) {
                //图片地址，先写死
                temp.setImgUrl("http://gndc.chbitech.com/" + temp.getImgUrl());
            }
        }
        response.setData(banners);
        return response;
    }

    /**
     * 开屏广告、弹窗广告
     *
     * @param advertisementRequest
     * @return
     */
    @PostMapping("/openingPopupAdvertisement")
    public ResponseMessage<List<Advertis>> openingPopupAdvertisement(@Validated @RequestBody POpeningPopupAdvertisementRequest advertisementRequest) {
        ResponseMessage<List<Advertis>> response = new ResponseMessage<>();
        Weekend<Advertis> weekend = Weekend.of(Advertis.class);
        weekend.selectProperties("link", "imgUrl", "productId");
        weekend.setOrderByClause("id desc");
        weekend.weekendCriteria()
                .andEqualTo(Advertis::getStatus, StatusEnum.NORMAL.getCode())
                .andEqualTo(Advertis::getAdvertisStatus, OnlineStatusEnum.ONLINE.getCode());
        List<Advertis> adverts = advertsService.selectByExample(weekend);
        response.setData(adverts);
        return response;
    }
}
