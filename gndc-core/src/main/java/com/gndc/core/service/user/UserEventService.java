package com.gndc.core.service.user;

import com.gndc.common.service.BaseService;
import com.gndc.core.model.UserEvent;

import java.util.Date;


public interface UserEventService extends BaseService<UserEvent, Integer> {

    /**
     * 打开app统计
     *
     * @param userId
     * @param ip
     * @return
     */
    int statisticsUserOpenApp(Integer userId, String ip);

    Integer selectUVCount(Integer userId, Integer productId, Date beginDate, Date endDate);
}
