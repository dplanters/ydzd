package com.gndc.core.mappers;

import com.gndc.core.api.partner.account.APLoginAdminInfo;
import com.gndc.core.model.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface APLoginAdminInfoMapping {

    APLoginAdminInfoMapping INSTANCE = Mappers.getMapper(APLoginAdminInfoMapping.class);

    APLoginAdminInfo convert(Admin admin);

}
