package com.gndc.common.mapper;


import com.gndc.common.model.Product;
import com.gndc.common.mybatis.MyMapper;

public interface ProductMapper extends MyMapper<Product, Integer> {


//    List<AOProductListResponse> aoProductList(@Param("sqlWhere") AOProductListRequest params);

//    long aoProductListCount(@Param("sqlWhere") AOProductListRequest params);

    /**
     * 产品管理-爆款列表
     *
     * @param request
     * @return
     */
//    List<AOProductHotListResponse> aoProductHotList(@Param("sqlWhere") AOProductHotListRequest request);

    /**
     * 客户端-首页-精选爆款列表
     * @return
     */
//    List<PHotProductResponse> selectPHotProductList();

    /**
     * 客户端-找贷款-产品列表
     * @return
     */
//    List<PFindProductResponse> selectPFindProductList(@Param("sqlWhere") PFindProductRequest findProductRequest);

    /**
     * 客户端-找贷款-申请数
     * @return
     */
//    List<PProductStaticUV> staticProductUV(@Param("productIds") List<Integer> productIds, @Param("eventTypes") List<Byte> eventTypes);
}