package com.gndc.core.mappers;

import com.gndc.core.api.sms.AOSmsChannelItem;
import com.gndc.core.model.SmsChannel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AOSmsChannelItemMapper {

    AOSmsChannelItemMapper INSTANCE = Mappers.getMapper(AOSmsChannelItemMapper.class);

    AOSmsChannelItem convert(SmsChannel smsChannel);
}
