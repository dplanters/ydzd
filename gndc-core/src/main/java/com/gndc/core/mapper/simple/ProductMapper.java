package com.gndc.core.mapper.simple;


import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.api.admin.product.AOProductHotListRequest;
import com.gndc.core.api.admin.product.AOProductHotListResponse;
import com.gndc.core.api.admin.product.AOProductListRequest;
import com.gndc.core.api.admin.product.AOProductListResponse;
import com.gndc.core.model.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper extends MyMapper<Product, Integer> {


    List<AOProductListResponse> aoProductList(@Param("sqlWhere") AOProductListRequest params);

    long aoProductListCount(@Param("sqlWhere") AOProductListRequest params);

    /**
     * 产品管理-爆款列表
     *
     * @param request
     * @return
     */
    List<AOProductHotListResponse> aoProductHotList(@Param("sqlWhere") AOProductHotListRequest request);

}