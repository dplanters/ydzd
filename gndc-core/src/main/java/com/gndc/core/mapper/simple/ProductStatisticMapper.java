package com.gndc.core.mapper.simple;


import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.model.ProductStatistic;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Mapper
public interface ProductStatisticMapper extends MyMapper<ProductStatistic, Integer> {

    /**
     * @Description
     * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
     */
    void batchSave(List<ProductStatistic> productClick);

    /**
     * @Description
     * @author <a href="hugaoxiang8619@adpanshi.com">hugaoxiang</a>
     */

    Map<String, BigDecimal> getSum();

//    List<ProductStatisticItem> selectProductStatisticByDayWithRowbounds(ProductStatisticCriteria criteria, PageBounds pageBounds);
//
//
//    List<ProductStatisticItem> selectProductStatisticByWeekWithRowbounds(@Param("dateStr") String dateStr, @Param("productId") Integer productId, PageBounds pageBounds);
//
//
//    List<ProductStatisticItem> selectProductStatisticByMonthWithRowbounds(@Param("dateStr") String dateStr, @Param("productId") Integer productId, PageBounds pageBounds);

}