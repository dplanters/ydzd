package com.gndc.core.mappers;

import com.gndc.core.api.admin.product.AOProductAddModifyRequest;
import com.gndc.core.api.admin.sys.AORightAddModifyRequest;
import com.gndc.core.model.Product;
import com.gndc.core.model.Right;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RightMapping {

    RightMapping INSTANCE = Mappers.getMapper(RightMapping.class);

    Right convert(AORightAddModifyRequest aoRightAddModifyRequest);
}
