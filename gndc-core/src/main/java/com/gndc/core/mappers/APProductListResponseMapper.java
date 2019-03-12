package com.gndc.core.mappers;

import com.gndc.core.api.partner.product.APProductListResponse;
import com.gndc.core.model.Product;
import com.gndc.core.model.ProductData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface APProductListResponseMapper {

    APProductListResponseMapper INSTANCE = Mappers.getMapper(APProductListResponseMapper.class);

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
