package com.gndc.core.mappers;

import com.gndc.core.api.admin.sys.AOAdminAddRequest;
import com.gndc.core.api.admin.sys.AOAdminModifyRequest;
import com.gndc.core.model.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminMapping {

    AdminMapping INSTANCE = Mappers.getMapper(AdminMapping.class);

    Admin convert(AOAdminAddRequest request);

    Admin convert(AOAdminModifyRequest request);
}
