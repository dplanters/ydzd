package com.gndc.core.mappers;

import com.gndc.core.api.admin.product.AOProductDetailResponse;
import com.gndc.core.model.Product;
import com.gndc.core.model.ProductData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface AOProductDetailResponseMapping {

    @Mappings({
            @Mapping(target = "id", source = "source1.id"),
            @Mapping(target = "partnerId", source = "source1.partnerId"),
            @Mapping(target = "name", source = "source1.name"),
            @Mapping(target = "description", source = "source1.description"),
            @Mapping(target = "borrowAmountBegin", source = "source1.borrowAmountBegin"),
            @Mapping(target = "borrowAmountEnd", source = "source1.borrowAmountEnd"),
            @Mapping(target = "productLink", source = "source1.androidLink"),
            @Mapping(target = "extra.dayRate", source = "source2.dayRate"),
            @Mapping(target = "extra.borrowPeriodStart", source = "source2.borrowPeriodStart"),
            @Mapping(target = "extra.borrowPeriodEnd", source = "source2.borrowPeriodEnd"),
            @Mapping(target = "extra.borrowPeriodUnit", source = "source2.borrowPeriodUnit"),
            @Mapping(target = "extra.borrowTimeDescription", source = "source2.borrowTimeDescription")
    })
    AOProductDetailResponse convert(Product source1, ProductData source2);
}
