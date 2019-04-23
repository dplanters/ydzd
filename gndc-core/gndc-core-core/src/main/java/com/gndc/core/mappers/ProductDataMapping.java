package com.gndc.core.mappers;

import com.gndc.core.api.admin.product.AOProductDataRequest;
import com.gndc.core.model.ProductData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductDataMapping {

    ProductData convert(AOProductDataRequest aoProductDataRequest);

}
