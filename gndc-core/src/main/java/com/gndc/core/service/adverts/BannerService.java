package com.gndc.core.service.adverts;

import com.gndc.common.service.BaseService;
import com.gndc.core.api.admin.operation.AOBannerListRequest;
import com.gndc.core.model.Banner;

import java.util.List;

public interface BannerService extends BaseService<Banner, Integer> {

    /**
     * 运营后台Banner列表
     */
    public List<Banner> bannerList(AOBannerListRequest request);
}
