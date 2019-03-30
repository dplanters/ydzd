package com.gndc.core.mappers;

import com.gndc.common.dto.PUserLoginInfoDTO;
import com.gndc.core.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PUserLoginInfoDTOMapping {

    PUserLoginInfoDTOMapping INSTANCE = Mappers.getMapper(PUserLoginInfoDTOMapping.class);

    PUserLoginInfoDTO convert(User user);
}
