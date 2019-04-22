package com.gndc.core.mapper;


import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.api.admin.product.AOProductHotListRequest;
import com.gndc.core.api.admin.product.AOProductHotListResponse;
import com.gndc.core.api.admin.product.AOProductListRequest;
import com.gndc.core.api.admin.product.AOProductListResponse;
import com.gndc.core.api.app.product.find.PFindProductRequest;
import com.gndc.core.api.app.product.find.PFindProductResponse;
import com.gndc.core.api.app.product.find.PProductStaticUV;
import com.gndc.core.api.app.product.hot.PHotProductResponse;
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

    /**
     * 客户端-首页-精选爆款列表
     * @return
     */
    List<PHotProductResponse> selectPHotProductList();

    /**
     * 客户端-找贷款-产品列表
     * @return
     */
    List<PFindProductResponse> selectPFindProductList(@Param("sqlWhere") PFindProductRequest findProductRequest);

    /**
     * 客户端-找贷款-申请数
     * @return
     */
    List<PProductStaticUV> staticProductUV(@Param("productIds") List<Integer> productIds, @Param("eventTypes") List<Byte> eventTypes);
}