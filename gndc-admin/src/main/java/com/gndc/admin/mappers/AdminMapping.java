package com.gndc.admin.mappers;

import com.gndc.admin.api.admin.sys.AOAdminAddRequest;
import com.gndc.admin.api.admin.sys.AOAdminModifyRequest;
import com.gndc.common.model.Admin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapping {

    Admin convert(AOAdminAddRequest request);

    Admin convert(AOAdminModifyRequest request);
}
