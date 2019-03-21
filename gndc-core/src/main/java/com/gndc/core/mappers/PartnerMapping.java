package com.gndc.core.mappers;

import com.gndc.core.api.admin.partner.AOPartnerAddRequest;
import com.gndc.core.api.admin.partner.AOPartnerModifyRequest;
import com.gndc.core.api.admin.sys.AOAdminAddRequest;
import com.gndc.core.api.admin.sys.AOAdminModifyRequest;
import com.gndc.core.model.Admin;
import com.gndc.core.model.Partner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PartnerMapping {

    PartnerMapping INSTANCE = Mappers.getMapper(PartnerMapping.class);

    Partner convert(AOPartnerAddRequest request);

    Partner convert(AOPartnerModifyRequest request);

}
