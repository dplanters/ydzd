package com.gndc.core.mappers;

import com.gndc.core.api.admin.sys.AORightAddRequest;
import com.gndc.core.api.admin.sys.AORightModifyRequest;
import com.gndc.core.model.Right;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RightMapping {

    Right convert(AORightAddRequest aoRightAddRequest);

    Right convert(AORightModifyRequest aoRightAddRequest);
}
