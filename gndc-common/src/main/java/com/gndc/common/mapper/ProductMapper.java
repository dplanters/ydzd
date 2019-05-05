package com.gndc.common.mapper;

import com.gndc.common.api.admin.product.AOProductSearchRequest;
import com.gndc.common.dto.ProductListDTO;
import com.gndc.common.model.Product;
import com.gndc.common.mybatis.MyMapper;

import java.util.List;

public interface ProductMapper extends MyMapper<Product,Integer> {

    List<ProductListDTO> selectProduct(AOProductSearchRequest param);

}