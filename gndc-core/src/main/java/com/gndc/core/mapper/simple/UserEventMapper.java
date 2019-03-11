package com.gndc.core.mapper.simple;

import com.gndc.common.api.Page;
import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.model.ProductStatistic;
import com.gndc.core.model.UserEvent;
import com.gndc.core.etc.user.UserDownload;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserEventMapper extends MyMapper<UserEvent, Integer> {

    /**
     * @Description
     * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
     */
    List<UserDownload> selectUserDownloadByUserId(@Param("userId") int userId, @Param("page") Page page);

    /**
     * @Description
     * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
     */
    long selectUserDownloadByUserIdCount(int userId);

    /**
     * @param i
     * @param date
     * @param sjd
     * @param now2
     * @Description
     * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
     */
    List<ProductStatistic> selectGroupByProductId(@Param("end") Date date, @Param("now") Date now2);

    Integer selectUVCount(@Param("userId") Integer userId, @Param("productId") Integer productId, @Param("beginDate") Date beginDate, @Param("endDate") Date endDate);
}