package com.gndc.core.mappers;

import com.gndc.core.api.admin.sys.AORightAddRequest;
import com.gndc.core.api.admin.sys.AORightModifyRequest;
import com.gndc.core.model.Right;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RightMapping {

    RightMapping INSTANCE = Mappers.getMapper(RightMapping.class);

    Right convert(AORightAddRequest aoRightAddRequest);

    Right convert(AORightModifyRequest aoRightAddRequest);
}
