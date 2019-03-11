package com.gndc.core.mapper.simple;

import com.gndc.common.api.Page;
import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.api.appsflyer.ChannelDataRequest;
import com.gndc.core.model.AppsflyerEvent;
import com.gndc.core.etc.appsflyer.ChannelData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AppsflyerEventMapper extends MyMapper<AppsflyerEvent, Integer> {

    /**
     * @param request
     * @param page
     * @return
     * @Description 按日查看
     * @author <a href="litianwei8504@adpanshi.com">litianwei</a>
     */
    List<ChannelData> selectChannelDataByDay(@Param("requestWhere") ChannelDataRequest request,
                                             @Param("page") Page page);

    long selectChannelDataCountByDay(@Param("requestWhere") ChannelDataRequest request);

    /**
     * @param request
     * @param page
     * @return
     * @Description 按周查看
     * @author <a href="litianwei8504@adpanshi.com">litianwei</a>
     */
    List<ChannelData> selectChannelDataByWeek(@Param("requestWhere") ChannelDataRequest request,
                                              @Param("page") Page page);

    long selectChannelDataCountByWeek(@Param("requestWhere") ChannelDataRequest request);

    /**
     * @param request
     * @param page
     * @return
     * @Description 按月查看
     * @author <a href="litianwei8504@adpanshi.com">litianwei</a>
     */
    List<ChannelData> selectChannelDataByMonth(@Param("requestWhere") ChannelDataRequest request,
                                               @Param("page") Page page);

    long selectChannelDataCountByMonth(@Param("requestWhere") ChannelDataRequest request);

    List<ChannelData> selectChannelDataDayAll(@Param("requestWhere") ChannelDataRequest request);

    List<ChannelData> selectChannelDataWeekAll(@Param("requestWhere") ChannelDataRequest request);

    List<ChannelData> selectChannelDataMonthAll(@Param("requestWhere") ChannelDataRequest request);
}