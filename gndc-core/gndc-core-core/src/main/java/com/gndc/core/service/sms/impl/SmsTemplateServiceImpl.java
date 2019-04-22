package com.gndc.core.service.sms.impl;

import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.core.api.admin.sms.AOSmsTemplateListRequest;
import com.gndc.core.api.admin.sms.AOSmsTemplateListResponse;
import com.gndc.core.mapper.SmsTemplateMapper;
import com.gndc.core.model.SmsTemplate;
import com.gndc.core.service.sms.SmsTemplateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 短信模板
 */
@Service
public class SmsTemplateServiceImpl extends BaseServiceImpl<SmsTemplate, Integer> implements SmsTemplateService {

    @Resource
    private SmsTemplateMapper smsTemplateMapper;

    @Override
    public List<AOSmsTemplateListResponse> selectTemplateWithAdminList(AOSmsTemplateListRequest request) {
        return smsTemplateMapper.selectTemplateWithAdminList(request);
    }
}
