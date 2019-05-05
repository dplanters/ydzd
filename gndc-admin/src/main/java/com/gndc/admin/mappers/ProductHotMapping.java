package com.gndc.admin.mappers;

import com.gndc.admin.api.admin.product.AOProductHotAddRequest;
import com.gndc.common.model.ProductHot;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductHotMapping {

    ProductHot convert(AOProductHotAddRequest aoProductAddRequest);
}
