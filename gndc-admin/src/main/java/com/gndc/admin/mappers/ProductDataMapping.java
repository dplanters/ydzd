package com.gndc.admin.mappers;

import com.gndc.admin.api.admin.product.AOProductDataRequest;
import com.gndc.common.model.ProductData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductDataMapping {

    ProductData convert(AOProductDataRequest aoProductDataRequest);

}
