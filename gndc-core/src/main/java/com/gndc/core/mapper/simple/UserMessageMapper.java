package com.gndc.core.mapper.simple;

import com.gndc.common.api.Page;
import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.model.UserMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMessageMapper extends MyMapper<UserMessage, Integer> {

    /**
     * 查询用户消息列表
     *
     * @param userId
     * @param page
     * @return
     * @Description
     * @author <a href="litianwei8504@adpanshi.com">litianwei8504</a>
     */
    List<?> getMessageList(@Param("userId") int userId, @Param("page") Page page);

    /**
     * 计算用户消息总数
     *
     * @param userId
     * @return
     * @Description
     * @author <a href="litianwei8504@adpanshi.com">litianwei8504</a>
     */
    long selectMessageCountByUser(Integer userId);
}