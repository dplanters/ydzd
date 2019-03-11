package com.gndc.core.mapper.simple;

import com.gndc.common.api.Page;
import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.api.banner.BannerListRequest;
import com.gndc.core.model.Banner;
import com.gndc.core.etc.banner.ExBanner;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BannerMapper extends MyMapper<Banner, Integer> {

    List<ExBanner> searchBannerList(@Param("sqlWhere") BannerListRequest sqlWhere, @Param("page") Page page);

    List<Banner> selectPBanners();

    long searchBannerListCount(@Param("sqlWhere") BannerListRequest sqlWhere);

    /**
     * @return
     * @Description banner新增后, 位置依次下降(position + 1)
     * @author <a href="litianwei8504@adpanshi.com">litianwei</a>
     */
    int updateDownPosition(int position);

    /**
     * @return
     * @Description banner删除后, 位置依次上升(position - 1)
     * @author <a href="litianwei8504@adpanshi.com">litianwei</a>
     */
    int updateUpPosition(int position);

    Banner selectByPosition(int position);

    int updateDownEditPosition(@Param("position") int position, @Param("getPosition") int getPosition);

    int updateUpEditPosition(@Param("position") int position, @Param("getPosition") int getPosition);

    int selectPositionMax();

    int selectOnLineCount();

    Banner selectByProductId(int productId);
}