package com.gndc.core.service.sms;

import com.gndc.common.service.BaseService;
import com.gndc.core.api.admin.sms.AOSmsGroupLogListRequest;
import com.gndc.core.api.admin.sms.AOSmsGroupLogListResponse;
import com.gndc.core.model.SmsGroupLog;

import java.util.List;

public interface SmsGroupLogService extends BaseService<SmsGroupLog, Integer> {
    List<AOSmsGroupLogListResponse> selectSmsGroupLogDetailList(AOSmsGroupLogListRequest request);
}
