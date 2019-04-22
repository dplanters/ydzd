package com.gndc.core.mappers;

import com.gndc.common.dto.RightInfoDTO;
import com.gndc.core.model.Right;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface RightInfoDTOMapping {

    @Mappings({
        @Mapping(source = "rightName", target = "rightName", ignore = true),
        @Mapping(source = "children", target = "children", ignore = true)
    })
    RightInfoDTO convert(Right right);
}
