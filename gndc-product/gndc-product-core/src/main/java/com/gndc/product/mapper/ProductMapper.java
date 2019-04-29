package com.gndc.product.mapper;

import com.gndc.common.mybatis.MyMapper;
import com.gndc.product.api.admin.product.AOProductSearchRequest;
import com.gndc.product.dto.ProductListDTO;
import com.gndc.product.model.Product;

import java.util.List;

public interface ProductMapper extends MyMapper<Product,Integer> {

    List<ProductListDTO> selectProduct(AOProductSearchRequest param);

}