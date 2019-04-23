package com.gndc.core.mappers;

import com.gndc.core.api.admin.sms.AOSmsSignAddRequest;
import com.gndc.core.api.admin.sms.AOSmsSignUpdateRequest;
import com.gndc.core.model.SmsSign;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface SmsSignMapping {

    SmsSign convert(AOSmsSignAddRequest request);

    @Mappings({
            @Mapping(target = "id", source = "signId")
    })
    SmsSign convert(AOSmsSignUpdateRequest request);
}
