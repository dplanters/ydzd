package com.gndc.core.mappers;

import com.gndc.common.dto.APAdminLoginInfoDTO;
import com.gndc.core.model.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface APAdminLoginInfoDTOMapping {

    APAdminLoginInfoDTOMapping INSTANCE = Mappers.getMapper(APAdminLoginInfoDTOMapping.class);

    APAdminLoginInfoDTO convert(Admin admin);

}
