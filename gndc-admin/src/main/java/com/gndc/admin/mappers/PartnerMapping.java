package com.gndc.admin.mappers;

import com.gndc.admin.api.admin.partner.AOPartnerAddRequest;
import com.gndc.admin.api.admin.partner.AOPartnerModifyRequest;
import com.gndc.common.model.Partner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PartnerMapping {

    Partner convert(AOPartnerAddRequest request);

    Partner convert(AOPartnerModifyRequest request);

}
