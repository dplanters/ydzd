package com.gndc.core.service.sms;

import com.gndc.common.service.BaseService;
import com.gndc.core.api.admin.sms.AOSmsTemplateListRequest;
import com.gndc.core.api.admin.sms.AOSmsTemplateListResponse;
import com.gndc.core.model.SmsTemplate;

import java.util.List;

public interface SmsTemplateService extends BaseService<SmsTemplate, Integer> {

    List<AOSmsTemplateListResponse> selectTemplateWithAdminList(AOSmsTemplateListRequest request);
}
