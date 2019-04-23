package com.gndc.core.mappers;

import com.gndc.core.api.admin.product.AOProductHotAddRequest;
import com.gndc.core.model.ProductHot;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductHotMapping {

    ProductHot convert(AOProductHotAddRequest aoProductAddRequest);
}
