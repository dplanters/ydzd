package com.gndc.core.mapper.simple;

import com.gndc.common.api.Page;
import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.api.feedback.FeedBackListRequest;
import com.gndc.core.model.UserFeedback;
import com.gndc.core.etc.feedback.UserFeedbackExt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserFeedbackMapper extends MyMapper<UserFeedback, Integer> {

    /**
     * @Description
     * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
     */
    List<UserFeedbackExt> searchFeedbackInfoList(@Param("feedWhere") FeedBackListRequest request,
                                                 @Param("page") Page page);

    /**
     * @Description
     * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
     */
    long searchFeedbackInfoListCount(@Param("feedWhere") FeedBackListRequest request);

    List<UserFeedback> selectByIds(List<Integer> ids);

    /**
     * @param feedbacks
     * @Description 批量修改反馈意见状态
     * @author <a href="chenmeng8430@adpanshi.com">chenmeng</a>
     */
    int batchUpdate(List<UserFeedback> feedbacks);
}