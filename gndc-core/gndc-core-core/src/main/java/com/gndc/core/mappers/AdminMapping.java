package com.gndc.core.mappers;

import com.gndc.core.api.admin.sys.AOAdminAddRequest;
import com.gndc.core.api.admin.sys.AOAdminModifyRequest;
import com.gndc.core.model.Admin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapping {

    Admin convert(AOAdminAddRequest request);

    Admin convert(AOAdminModifyRequest request);
}
