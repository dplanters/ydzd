package com.gndc.core.mapper.simple;

import com.gndc.common.api.Page;
import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.api.advertis.AdvertisListRequest;
import com.gndc.core.etc.advertis.ExAdvertis;
import com.gndc.core.model.Advertis;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdvertisMapper extends MyMapper<Advertis, Integer> {

    List<ExAdvertis> searchadvertisList(@Param("sqlWhere") AdvertisListRequest sqlWhere, @Param("page") Page page);

    long searchadvertisListCount(@Param("sqlWhere") AdvertisListRequest sqlWhere);

    int selectOnLineCount(int advertisType);

    Advertis selectByProductId(int productId);

    /**
     * @Description
     * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
     */
    List<ExAdvertis> selectAdvertisByType(int type);
}