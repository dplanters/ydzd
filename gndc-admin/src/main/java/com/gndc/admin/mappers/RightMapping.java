package com.gndc.admin.mappers;

import com.gndc.admin.api.admin.sys.AORightAddRequest;
import com.gndc.admin.api.admin.sys.AORightModifyRequest;
import com.gndc.common.model.Right;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RightMapping {

    Right convert(AORightAddRequest aoRightAddRequest);

    Right convert(AORightModifyRequest aoRightAddRequest);
}
