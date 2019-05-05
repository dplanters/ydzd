package com.gndc.admin.mappers;

import com.gndc.admin.api.admin.sms.AOSmsTimingSendRequest;
import com.gndc.common.model.SmsJobCondition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface SmsJobConditionMapping {

    @Mappings({
            @Mapping(target = "signIds", expression = "java(cn.hutool.core.util.StrUtil.join( \",\",request.getSmsSignIds()))"),
            @Mapping(target = "operatorIds", expression = "java(cn.hutool.core.util.StrUtil.join(\",\",request.getOperatorIds()))"),
            @Mapping(target = "phones", expression = "java(cn.hutool.core.util.StrUtil.join(\",\",request.getPhones()))"),
            @Mapping(target = "createAdminId", source = "aoAdmin.id")
    })
    SmsJobCondition convert(AOSmsTimingSendRequest request);
}
