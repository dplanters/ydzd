package com.gndc.core.mappers;

import com.gndc.common.dto.APAdminLoginInfoDTO;
import com.gndc.core.model.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface APAdminLoginInfoDTOMapping {

    APAdminLoginInfoDTOMapping INSTANCE = Mappers.getMapper(APAdminLoginInfoDTOMapping.class);

    @Mapping(source = "rights", target = "rights", ignore = true)
    APAdminLoginInfoDTO convert(Admin admin);

}
