package com.gndc.admin.mappers;

import com.gndc.admin.api.partner.product.APProductListResponse;
import com.gndc.common.model.Product;
import com.gndc.common.model.ProductData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface APProductListResponseMapping {

    @Mappings({
            @Mapping(target = "id", source = "source1.id"),
            @Mapping(target = "partnerId", source = "source1.partnerId"),
            @Mapping(target = "name", source = "source1.name"),
            @Mapping(target = "description", source = "source1.description"),
            @Mapping(target = "borrowAmountBegin", source = "source1.borrowAmountBegin"),
            @Mapping(target = "borrowAmountEnd", source = "source1.borrowAmountEnd"),
            @Mapping(target = "borrowPeriodStart", source = "source2.borrowPeriodStart"),
            @Mapping(target = "borrowPeriodEnd", source = "source2.borrowPeriodEnd"),
            @Mapping(target = "borrowPeriodUnit", source = "source2.borrowPeriodUnit"),
    })
    APProductListResponse convert(Product source1, ProductData source2);
}
