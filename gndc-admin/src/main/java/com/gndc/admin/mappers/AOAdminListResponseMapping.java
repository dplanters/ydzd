package com.gndc.admin.mappers;

import com.gndc.admin.api.admin.sys.AOAdminListResponse;
import com.gndc.common.model.Admin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AOAdminListResponseMapping {

    AOAdminListResponse convert(Admin admin);
}
