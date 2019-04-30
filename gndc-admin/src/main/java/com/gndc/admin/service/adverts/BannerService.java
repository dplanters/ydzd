package com.gndc.admin.service.adverts;

import com.gndc.common.service.BaseService;
import com.gndc.admin.api.admin.operation.AOBannerListRequest;
import com.gndc.common.model.Banner;

import java.util.List;

public interface BannerService extends BaseService<Banner, Integer> {

    /**
     * 运营后台Banner列表
     */
    public List<Banner> bannerList(AOBannerListRequest request);
}
