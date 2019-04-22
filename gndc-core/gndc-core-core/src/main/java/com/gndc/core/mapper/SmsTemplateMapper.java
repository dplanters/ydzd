package com.gndc.core.mapper;

import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.api.admin.sms.AOSmsTemplateListRequest;
import com.gndc.core.api.admin.sms.AOSmsTemplateListResponse;
import com.gndc.core.model.SmsTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmsTemplateMapper extends MyMapper<SmsTemplate, Integer> {
    List<AOSmsTemplateListResponse> selectTemplateWithAdminList(@Param("options") AOSmsTemplateListRequest request);
}