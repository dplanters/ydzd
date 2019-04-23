package com.gndc.core.mappers;

import com.gndc.common.dto.PUserLoginInfoDTO;
import com.gndc.core.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PUserLoginInfoDTOMapping {

    PUserLoginInfoDTO convert(User user);
}
