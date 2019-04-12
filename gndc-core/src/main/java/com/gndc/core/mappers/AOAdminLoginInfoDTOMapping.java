package com.gndc.core.mappers;

import com.gndc.common.dto.AOAdminLoginInfoDTO;
import com.gndc.core.model.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AOAdminLoginInfoDTOMapping {

    AOAdminLoginInfoDTOMapping INSTANCE = Mappers.getMapper(AOAdminLoginInfoDTOMapping.class);

    @Mapping(source = "rights", target = "rights", ignore = true)
    AOAdminLoginInfoDTO convert(Admin admin);

}
