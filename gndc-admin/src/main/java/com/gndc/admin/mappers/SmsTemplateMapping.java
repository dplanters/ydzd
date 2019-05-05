package com.gndc.admin.mappers;

import com.gndc.admin.api.admin.sms.AOSmsTemplateAddRequest;
import com.gndc.admin.api.admin.sms.AOSmsTemplateUpdateRequest;
import com.gndc.common.model.SmsTemplate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface SmsTemplateMapping {

    @Mappings({
            @Mapping(target = "id", source = "templateId"),
            @Mapping(target = "operatorId", source = "aoAdmin.id")
    })
    SmsTemplate convert(AOSmsTemplateUpdateRequest request);

    @Mappings({
            @Mapping(target = "operatorId", source = "aoAdmin.id")
    })
    SmsTemplate convert(AOSmsTemplateAddRequest request);
}
