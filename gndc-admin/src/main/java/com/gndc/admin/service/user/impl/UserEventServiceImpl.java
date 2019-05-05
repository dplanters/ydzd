package com.gndc.admin.service.user.impl;

import cn.hutool.core.date.DateUtil;
import com.gndc.common.enums.user.UserEventsTypeEnum;
import com.gndc.common.model.BaseEntity;
import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.common.mapper.UserEventMapper;
import com.gndc.common.model.UserEvent;
import com.gndc.admin.service.user.UserEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;

import java.util.Date;
import java.util.List;

@Service
public class UserEventServiceImpl extends BaseServiceImpl<UserEvent, Integer> implements UserEventService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserEventMapper userEventMapper;

    /**
     * 打开app统计
     *
     * @param userId
     * @param ip
     * @return
     */
    @Override
    public int statisticsUserOpenApp(Integer userId, String ip) {
        int ref = 0;
        Date now = DateUtil.date().toJdkDate();

        Date start = DateUtil.beginOfDay(now);
        Date end = DateUtil.endOfDay(now);

        Weekend<UserEvent> weekend = Weekend.of(UserEvent.class);
        weekend.selectProperties("id");
        weekend.weekendCriteria()
                .andEqualTo(UserEvent::getUserId, userId)
                .andBetween(BaseEntity::getCreateTime, start, end)
                .andEqualTo(UserEvent::getEventType, UserEventsTypeEnum.OPEN_APP.getCode());

        List<UserEvent> events = selectByExample(weekend);
        if (events == null || events.size() == 0) {
            UserEvent event = new UserEvent();
            event.setUserId(userId);
            event.setCreateTime(now);
            event.setEventTime(now);
            event.setEventType(UserEventsTypeEnum.OPEN_APP.getCode());
            event.setIpAddress(ip);
            event.setUpdateTime(now);
            insertSelective(event);
            redisTemplate.execute(new RedisCallback<Long>() {
                @Override
                public Long doInRedis(RedisConnection connection) throws DataAccessException {
                    connection.incrBy(redisTemplate.getStringSerializer().serialize(UserEventsTypeEnum.OPEN_APP.getName()), 1);
                    return 1L;
                }
            });
        }
        return ref;
    }

    @Override
    public Integer selectUVCount(Integer userId, Integer productId, Date beginDate, Date endDate) {
        return userEventMapper.selectUVCount(userId, productId, beginDate, endDate);
    }
}
