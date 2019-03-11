package com.gndc.core.mappers;

import com.gndc.core.api.sms.AOSmsSignItem;
import com.gndc.core.model.SmsSign;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AOSmsSignItemMapper {

    AOSmsSignItemMapper INSTANCE = Mappers.getMapper(AOSmsSignItemMapper.class);

    AOSmsSignItem convert(SmsSign smsSign);
}
