package com.gndc.admin.mappers;

import com.gndc.admin.api.admin.sms.AOSmsSignAddRequest;
import com.gndc.admin.api.admin.sms.AOSmsSignUpdateRequest;
import com.gndc.common.model.SmsSign;
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
