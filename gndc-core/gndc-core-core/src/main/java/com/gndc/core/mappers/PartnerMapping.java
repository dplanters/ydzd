package com.gndc.core.mappers;

import com.gndc.core.api.admin.partner.AOPartnerAddRequest;
import com.gndc.core.api.admin.partner.AOPartnerModifyRequest;
import com.gndc.core.model.Partner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PartnerMapping {

    Partner convert(AOPartnerAddRequest request);

    Partner convert(AOPartnerModifyRequest request);

}
