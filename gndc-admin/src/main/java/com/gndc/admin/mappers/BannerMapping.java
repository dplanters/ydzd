package com.gndc.admin.mappers;

import com.gndc.admin.api.admin.operation.AOBannerAddRequest;
import com.gndc.admin.api.admin.operation.AOBannerModifyRequest;
import com.gndc.admin.dto.BannerDTO;
import com.gndc.common.model.Banner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BannerMapping {

    Banner convert(AOBannerAddRequest request);

    Banner convert(AOBannerModifyRequest request);

    Banner convert(BannerDTO bannerDTO);
}
