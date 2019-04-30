package com.gndc.admin.service.sms.impl;

import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.admin.api.admin.sms.AOSmsConditionListRequest;
import com.gndc.admin.api.admin.sms.AOSmsConditionListResponse;
import com.gndc.common.mapper.SmsConditionMapper;
import com.gndc.common.model.SmsCondition;
import com.gndc.admin.service.sms.SmsConditionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 短信条件
 */
@Service
public class SmsConditionServiceImpl extends BaseServiceImpl<SmsCondition, Integer> implements SmsConditionService {

    @Resource
    private SmsConditionMapper smsConditionMapper;

    @Override
    public List<AOSmsConditionListResponse> selectConditionWithAdminList(AOSmsConditionListRequest request) {
//        return smsConditionMapper.selectConditionWithAdminList(request);
        return null;
    }
}
