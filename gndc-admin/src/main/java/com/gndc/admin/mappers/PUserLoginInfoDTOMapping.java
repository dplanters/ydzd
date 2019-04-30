package com.gndc.admin.mappers;

import com.gndc.common.dto.PUserLoginInfoDTO;
import com.gndc.common.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PUserLoginInfoDTOMapping {

    PUserLoginInfoDTO convert(User user);
}
