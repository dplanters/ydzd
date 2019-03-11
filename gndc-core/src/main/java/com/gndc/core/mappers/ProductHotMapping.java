package com.gndc.core.mappers;

import com.gndc.core.api.product.AOProductHotEditRequest;
import com.gndc.core.model.ProductHot;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductHotMapping {

    ProductHotMapping INSTANCE = Mappers.getMapper(ProductHotMapping.class);

    @Mappings({
            @Mapping(target = "status", source = "hotStatus")
    })
    ProductHot convert(AOProductHotEditRequest aoProductAddRequest);
}
