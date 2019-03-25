package com.gndc.core.mappers;

import com.gndc.core.api.admin.sys.AOAdminAddRequest;
import com.gndc.core.api.admin.sys.AOAdminModifyRequest;
import com.gndc.core.model.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminMapping {

    AdminMapping INSTANCE = Mappers.getMapper(AdminMapping.class);

    @Mappings({
            @Mapping(target = "platform", source = "platform")
    })
    Admin convert(AOAdminAddRequest request);

    @Mappings({
            @Mapping(target = "platform", source = "platform")
    })
    Admin convert(AOAdminModifyRequest request);
}
