package com.gndc.core.mappers;

import com.gndc.core.api.admin.sms.AOSmsTimingSendRequest;
import com.gndc.core.model.SmsJobCondition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SmsJobConditionMapping {

    SmsJobConditionMapping INSTANCE = Mappers.getMapper(SmsJobConditionMapping.class);

    @Mappings({
            @Mapping(target = "signIds", expression = "java(cn.hutool.core.util.StrUtil.join( \",\",request.getSmsSignIds()))"),
            @Mapping(target = "operatorIds", expression = "java(cn.hutool.core.util.StrUtil.join(\",\",request.getOperatorIds()))"),
            @Mapping(target = "createAdminId", source = "aoAdmin.id")
    })
    SmsJobCondition convert(AOSmsTimingSendRequest request);
}
