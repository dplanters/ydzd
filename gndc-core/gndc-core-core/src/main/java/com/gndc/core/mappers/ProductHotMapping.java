package com.gndc.core.mappers;

import com.gndc.core.api.admin.product.AOProductHotAddRequest;
import com.gndc.core.model.ProductHot;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductHotMapping {

    ProductHotMapping INSTANCE = Mappers.getMapper(ProductHotMapping.class);

    ProductHot convert(AOProductHotAddRequest aoProductAddRequest);
}
