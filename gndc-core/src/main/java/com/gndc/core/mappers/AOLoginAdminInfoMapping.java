package com.gndc.core.mappers;

import com.gndc.core.api.admin.account.AOLoginAdminInfo;
import com.gndc.core.model.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AOLoginAdminInfoMapping {

    AOLoginAdminInfoMapping INSTANCE = Mappers.getMapper(AOLoginAdminInfoMapping.class);

    AOLoginAdminInfo convert(Admin admin);

}
