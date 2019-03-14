package com.gndc.core.controller.app.ad;

import com.gndc.core.api.common.ResponseMessage;
import com.gndc.common.enums.common.DelType;
import com.gndc.common.enums.product.ProductStatus;
import com.gndc.core.api.app.ad.PBannerListRequest;
import com.gndc.core.api.app.ad.POpeningPopupAdvertisementRequest;
import com.gndc.core.model.Banner;
import com.gndc.core.service.banner.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.weekend.Weekend;

import java.util.Date;
import java.util.List;

/**
 * 客户端banner轮播图
 */
@RestController
@RequestMapping("/app/ad")
public class PAdvertisementController {

    @Autowired
    private BannerService bannerService;

    @RequestMapping("/bannerList")
    public ResponseMessage<List<Banner>> bannerList(PBannerListRequest bannerListRequest) {
        ResponseMessage<List<Banner>> response = new ResponseMessage<>();

        Date currTime = new Date();
        Weekend<Banner> weekend = Weekend.of(Banner.class);
        weekend.selectProperties("position", "link", "imgUrl", "productId");
        weekend.weekendCriteria()
                .andLessThanOrEqualTo(Banner::getBeginTime, currTime)
                .andGreaterThanOrEqualTo(Banner::getEndTime, currTime)
                .andEqualTo(Banner::getStatus, ProductStatus.ON_LINE.getCode())
                .andEqualTo(Banner::getIsDel, DelType.NORMAL.getCode());

        List<Banner> banners = bannerService.selectByExample(weekend);
        response.setData(banners);
        return response;
    }
    @RequestMapping("/openingPopupAdvertisement")
    public ResponseMessage<List<Banner>> openingPopupAdvertisement(POpeningPopupAdvertisementRequest advertisementRequest) {
        ResponseMessage<List<Banner>> response = new ResponseMessage<>();

        Date currTime = new Date();
        Weekend<Banner> weekend = Weekend.of(Banner.class);
        weekend.selectProperties("position", "link", "imgUrl", "productId");
        weekend.weekendCriteria()
                .andLessThanOrEqualTo(Banner::getBeginTime, currTime)
                .andGreaterThanOrEqualTo(Banner::getEndTime, currTime)
                .andEqualTo(Banner::getStatus, ProductStatus.ON_LINE.getCode())
                .andEqualTo(Banner::getIsDel, DelType.NORMAL.getCode());

        List<Banner> banners = bannerService.selectByExample(weekend);
        response.setData(banners);
        return response;
    }
}
