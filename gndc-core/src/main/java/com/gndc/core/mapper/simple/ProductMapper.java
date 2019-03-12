package com.gndc.core.mapper.simple;


import com.github.pagehelper.PageInfo;
import com.gndc.common.api.Page;
import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.api.product.*;
import com.gndc.core.model.Product;
import com.gndc.core.etc.product.PProductStaticUV;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper extends MyMapper<Product, Integer> {

    /**
     * @Description
     * @author <a href="chenzuozhou@adpanshi.com">chenzuozhou</a>
     */
    List<PProductStaticUV> staticProductUV(@Param("productIds") List<Integer> productIds, @Param("eventTypes") List<Byte> eventTypes);

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