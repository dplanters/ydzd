package com.gndc.core.mappers;

import com.gndc.core.api.admin.operation.AOBannerAddRequest;
import com.gndc.core.api.admin.operation.AOBannerModifyRequest;
import com.gndc.core.dto.BannerDTO;
import com.gndc.core.model.Banner;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BannerMapping {

    BannerMapping INSTANCE = Mappers.getMapper(BannerMapping.class);

    Banner convert(AOBannerAddRequest request);

    Banner convert(AOBannerModifyRequest request);

    Banner convert(BannerDTO bannerDTO);
}
