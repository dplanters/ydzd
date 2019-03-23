package com.gndc.core.mappers;

import com.gndc.core.api.admin.sms.AOSmsConditionEditRequest;
import com.gndc.core.model.SmsCondition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SmsConditionMapping {

    SmsConditionMapping INSTANCE = Mappers.getMapper(SmsConditionMapping.class);
    @Mappings({
            @Mapping(target = "id", source = "conditionId"),
            @Mapping(target = "condition", expression = "java(com.alibaba.fastjson.JSONObject.toJSONString(request.getSmsConditionContent(), false))"),
            @Mapping(target = "createAdminId", source = "admin.id")
    })
    SmsCondition convert(AOSmsConditionEditRequest request);
}
