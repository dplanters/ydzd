package com.gndc.core.mappers;

import com.gndc.core.api.admin.sms.AOSmsSignEditRequest;
import com.gndc.core.model.SmsSign;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SmsSignMapping {

    SmsSignMapping INSTANCE = Mappers.getMapper(SmsSignMapping.class);

    @Mappings({
            @Mapping(target = "id", source = "signId")
    })
    SmsSign convert(AOSmsSignEditRequest request);
}
