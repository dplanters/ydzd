package com.gndc.core.mappers;

import com.gndc.core.api.admin.sys.AOAdminListResponse;
import com.gndc.core.model.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AOAdminListResponseMapping {

    AOAdminListResponse convert(Admin admin);
}
