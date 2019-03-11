package com.gndc.core.mapper.simple;

import com.gndc.common.api.Page;
import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.api.customerservice.UserCallRecordRequest;
import com.gndc.core.model.UserCallRecord;
import com.gndc.core.model.UserCallRecordExt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserCallRecordMapper extends MyMapper<UserCallRecord, Integer> {

    /**
     * @Description
     * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
     */
    List<UserCallRecordExt> selectUserCallList(@Param("userCall") UserCallRecordRequest request,
                                               @Param("page") Page page);

    /**
     * 获得客服用户来访记录总数
     *
     * @param request
     * @return
     * @Description
     * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
     */
    long selectUserCallListCount(@Param("userCall") UserCallRecordRequest request);
}