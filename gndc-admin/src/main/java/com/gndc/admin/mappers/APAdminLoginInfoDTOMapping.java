package com.gndc.admin.mappers;

import com.gndc.common.dto.APAdminLoginInfoDTO;
import com.gndc.common.model.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface APAdminLoginInfoDTOMapping {

    @Mapping(source = "rights", target = "rights", ignore = true)
    APAdminLoginInfoDTO convert(Admin admin);

}
