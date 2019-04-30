package com.gndc.product.mapper;

import com.gndc.common.mybatis.MyMapper;
import com.gndc.product.api.admin.product.productincomingconfig.AOProductIncomingConfigSearchRequest;
import com.gndc.product.model.ProductIncomingConfig;

import java.util.List;

public interface ProductIncomingConfigMapper extends MyMapper<ProductIncomingConfig,Integer> {


    List<Object> selectProductIncomingConfigPage(AOProductIncomingConfigSearchRequest param);

}