package com.gndc.core.mappers;

import com.gndc.common.dto.AOAdminLoginInfoDTO;
import com.gndc.core.model.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AOAdminLoginInfoDTOMapping {

    @Mapping(source = "rights", target = "rights", ignore = true)
    AOAdminLoginInfoDTO convert(Admin admin);

}
