package com.gndc.core.mappers;

import com.gndc.common.dto.AOAdminLoginInfoDTO;
import com.gndc.core.model.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AOAdminLoginInfoDTOMapping {

    AOAdminLoginInfoDTOMapping INSTANCE = Mappers.getMapper(AOAdminLoginInfoDTOMapping.class);

    AOAdminLoginInfoDTO convert(Admin admin);

}
