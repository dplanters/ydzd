package com.gndc.core.mappers;

import com.gndc.core.api.admin.product.AOProductAddRequest;
import com.gndc.core.api.admin.product.AOProductModifyRequest;
import com.gndc.core.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapping {

    ProductMapping INSTANCE = Mappers.getMapper(ProductMapping.class);

    @Mappings({
            @Mapping(target = "androidLink", source = "productLink"),
            @Mapping(target = "iosLink", source = "productLink")
    })
    Product convert(AOProductAddRequest request);

    @Mappings({
            @Mapping(target = "androidLink", source = "productLink"),
            @Mapping(target = "iosLink", source = "productLink")
    })
    Product convert(AOProductModifyRequest request);
}
