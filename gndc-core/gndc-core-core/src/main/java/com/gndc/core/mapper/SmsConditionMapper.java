package com.gndc.core.mapper;

import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.api.admin.sms.AOSmsConditionListRequest;
import com.gndc.core.api.admin.sms.AOSmsConditionListResponse;
import com.gndc.core.model.SmsCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmsConditionMapper extends MyMapper<SmsCondition, Integer> {
    List<AOSmsConditionListResponse> selectConditionWithAdminList(@Param("options") AOSmsConditionListRequest request);
}