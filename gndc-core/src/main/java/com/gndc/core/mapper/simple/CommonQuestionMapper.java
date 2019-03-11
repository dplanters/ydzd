package com.gndc.core.mapper.simple;

import com.gndc.common.api.Page;
import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.api.question.QuestionListRequest;
import com.gndc.core.model.CommonQuestion;
import com.gndc.core.etc.question.ExCommonQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommonQuestionMapper extends MyMapper<CommonQuestion, Integer> {
    /**
     * @param page
     * @return
     * @Description 常见问题 列表
     * @author <a href="limengwu8493@adpanshi.com">limengwu</a>
     */
    List<ExCommonQuestion> selectQuestionPageList(@Param("record") CommonQuestion record, @Param("page") Page page,
                                                  @Param("whereReq") QuestionListRequest whereReq);

    /**
     * @return
     * @Description 记录数量
     * @author <a href="limengwu8493@adpanshi.com">limengwu</a>
     */
    long selectQuestionCount(@Param("record") CommonQuestion record, @Param("whereReq") QuestionListRequest whereReq);
}