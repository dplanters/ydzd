package com.gndc.admin.service.sms.impl;

import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.admin.api.admin.sms.AOSmsTemplateListRequest;
import com.gndc.admin.api.admin.sms.AOSmsTemplateListResponse;
import com.gndc.common.mapper.SmsTemplateMapper;
import com.gndc.common.model.SmsTemplate;
import com.gndc.admin.service.sms.SmsTemplateService;
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
//        return smsTemplateMapper.selectTemplateWithAdminList(request);
        return null;
    }
}
