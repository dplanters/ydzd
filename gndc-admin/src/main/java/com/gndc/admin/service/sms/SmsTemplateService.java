package com.gndc.admin.service.sms;

import com.gndc.common.service.BaseService;
import com.gndc.admin.api.admin.sms.AOSmsTemplateListRequest;
import com.gndc.admin.api.admin.sms.AOSmsTemplateListResponse;
import com.gndc.common.model.SmsTemplate;

import java.util.List;

public interface SmsTemplateService extends BaseService<SmsTemplate, Integer> {

    List<AOSmsTemplateListResponse> selectTemplateWithAdminList(AOSmsTemplateListRequest request);
}
