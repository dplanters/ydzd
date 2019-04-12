package com.gndc.core.mappers;

import com.gndc.common.dto.RightInfoDTO;
import com.gndc.core.model.Right;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RightInfoDTOMapping {

    RightInfoDTOMapping INSTANCE = Mappers.getMapper(RightInfoDTOMapping.class);

    @Mappings({
        @Mapping(source = "rightName", target = "rightName", ignore = true),
        @Mapping(source = "children", target = "children", ignore = true)
    })
    RightInfoDTO convert(Right right);
}
