package com.gndc.core.mappers;

import com.gndc.core.api.admin.product.AOProductDataModifyRequest;
import com.gndc.core.model.ProductData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductDataMapping {

    ProductDataMapping INSTANCE = Mappers.getMapper(ProductDataMapping.class);

    ProductData convert(AOProductDataModifyRequest aoProductDataRequest);

}
