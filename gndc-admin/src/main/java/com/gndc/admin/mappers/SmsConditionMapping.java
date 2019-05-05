package com.gndc.admin.mappers;

import com.gndc.admin.api.admin.sms.AOSmsConditionAddRequest;
import com.gndc.admin.api.admin.sms.AOSmsConditionUpdateRequest;
import com.gndc.common.model.SmsCondition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface SmsConditionMapping {

    @Mappings({
            @Mapping(target = "id", source = "conditionId"),
            @Mapping(target = "condition", expression = "java(com.alibaba.fastjson.JSONObject.toJSONString(request.getSmsConditionContent(), false))"),
            @Mapping(target = "createAdminId", source = "aoAdmin.id")
    })
    SmsCondition convert(AOSmsConditionUpdateRequest request);

    @Mappings({
            @Mapping(target = "condition", expression = "java(com.alibaba.fastjson.JSONObject.toJSONString(request.getSmsConditionContent(), false))"),
            @Mapping(target = "createAdminId", source = "aoAdmin.id")
    })
    SmsCondition convert(AOSmsConditionAddRequest request);
}
