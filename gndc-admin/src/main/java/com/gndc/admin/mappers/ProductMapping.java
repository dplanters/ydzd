package com.gndc.admin.mappers;

import com.gndc.admin.api.admin.product.AOProductAddRequest;
import com.gndc.admin.api.admin.product.AOProductModifyRequest;
import com.gndc.common.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductMapping {

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
