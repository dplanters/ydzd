package com.gndc.core.mappers;

import com.gndc.core.api.admin.sms.AOSmsTemplateAddRequest;
import com.gndc.core.api.admin.sms.AOSmsTemplateUpdateRequest;
import com.gndc.core.model.SmsTemplate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface SmsTemplateMapping {

    @Mappings({
            @Mapping(target = "id", source = "templateId"),
            @Mapping(target = "createAdminId", source = "aoAdmin.id")
    })
    SmsTemplate convert(AOSmsTemplateUpdateRequest request);

    @Mappings({
            @Mapping(target = "createAdminId", source = "aoAdmin.id")
    })
    SmsTemplate convert(AOSmsTemplateAddRequest request);
}
