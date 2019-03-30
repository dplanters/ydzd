package com.gndc.core.mappers;

import com.gndc.common.dto.RightInfoDTO;
import com.gndc.core.model.Right;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RightInfoDTOMapping {

    RightInfoDTOMapping INSTANCE = Mappers.getMapper(RightInfoDTOMapping.class);

    RightInfoDTO convert(Right right);
}
