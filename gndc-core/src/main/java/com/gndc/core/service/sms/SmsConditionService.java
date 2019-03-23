package com.gndc.core.service.sms;

import com.gndc.common.service.BaseService;
import com.gndc.core.api.admin.sms.AOSmsConditionListRequest;
import com.gndc.core.api.admin.sms.AOSmsConditionListResponse;
import com.gndc.core.model.SmsCondition;

import java.util.List;

public interface SmsConditionService extends BaseService<SmsCondition, Integer> {
    List<AOSmsConditionListResponse> selectConditionWithAdminList(AOSmsConditionListRequest request);
}
