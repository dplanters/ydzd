package com.gndc.admin.service.sms;

import com.gndc.admin.api.admin.sms.AOSmsConditionListRequest;
import com.gndc.admin.api.admin.sms.AOSmsConditionListResponse;
import com.gndc.common.model.SmsCondition;
import com.gndc.common.service.BaseService;

import java.util.List;

public interface SmsConditionService extends BaseService<SmsCondition, Integer> {
    List<AOSmsConditionListResponse> selectConditionWithAdminList(AOSmsConditionListRequest request);
}
