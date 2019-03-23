package com.gndc.core.service.adverts.impl;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gndc.common.enums.common.DelEnum;
import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.core.api.admin.operation.AOBannerListRequest;
import com.gndc.core.mapper.simple.BannerMapper;
import com.gndc.core.model.Banner;
import com.gndc.core.service.adverts.BannerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.List;

/**
 * banner轮播图
 */
@Slf4j
@Service
public class BannerServiceImpl extends BaseServiceImpl<Banner, Integer> implements BannerService {

    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public List<Banner> bannerList(AOBannerListRequest request) {
        PageInfo page = request.getHeader().getPage();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());

        Weekend<Banner> weekend = Weekend.of(Banner.class);
        weekend.orderBy("position").desc();
        WeekendCriteria<Banner, Object> weekendCriteria = weekend.weekendCriteria();
        weekendCriteria
                .andEqualTo(Banner::getIsDel, DelEnum.NORMAL.getCode())
                .andEqualTo(Banner::getStatus, ObjectUtil.defaultIfNull(request.getStatus(), null))
                .andGreaterThanOrEqualTo(Banner::getCreateTime, ObjectUtil.defaultIfNull(request.getStartTime(), null))
                .andLessThanOrEqualTo(Banner::getCreateTime, ObjectUtil.defaultIfNull(request.getEndTime(), null));
        List<Banner> banners = bannerMapper.selectByExample(weekend);

        return banners;
    }
}
