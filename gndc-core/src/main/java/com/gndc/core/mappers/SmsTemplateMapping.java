package com.gndc.core.mappers;

import com.gndc.core.api.admin.sms.AOSmsTemplateEditRequest;
import com.gndc.core.model.SmsTemplate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SmsTemplateMapping {

    SmsTemplateMapping INSTANCE = Mappers.getMapper(SmsTemplateMapping.class);

    @Mappings({
            @Mapping(target = "id", source = "templateId")
    })
    SmsTemplate convert(AOSmsTemplateEditRequest request);
}
