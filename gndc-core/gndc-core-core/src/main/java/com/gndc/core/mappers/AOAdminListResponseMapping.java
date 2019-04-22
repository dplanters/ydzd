package com.gndc.core.mappers;

import com.gndc.core.api.admin.sys.AOAdminListResponse;
import com.gndc.core.model.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AOAdminListResponseMapping {

    AOAdminListResponseMapping INSTANCE = Mappers.getMapper(AOAdminListResponseMapping.class);

    AOAdminListResponse convert(Admin admin);
}
