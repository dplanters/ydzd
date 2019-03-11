package com.gndc.core.mapper.simple;


import com.gndc.common.api.Page;
import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.api.product.*;
import com.gndc.core.model.Product;
import com.gndc.core.etc.product.PProductStaticUV;
import com.gndc.core.etc.product.ProductDataExpansion;
import com.gndc.core.etc.product.ProductDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper extends MyMapper<Product, Integer> {
    /**
     * @return
     * @Description 根据产品名查询产品
     * @author <a href="litianwei8504@adpanshi.com">litianwei</a>
     */
    Product selectProductByName(String name);

    /**
     * @return
     * @Description 查询热推列表
     * @author <a href="hugaoxiang8619@adpanshi.com">hugaoxiang</a>
     */

//    List<ProductDataExpansion> selectProductRecommendDetailWithRowbounds(@Param("status") byte status,
//                                                                         PageBounds pageBounds);

    /**
     * @return
     * @Description 查询产品列表
     * @author <a href="hugaoxiang8619@adpanshi.com">hugaoxiang</a>
     */

//    List<ProductDataExpansion> selectProductBySortTypeWithRowbounds(@Param("status") byte status,
//                                                                    @Param("sort") byte sort, PageBounds pageBounds);

    /**
     * @return
     * @Description 排序查询所有产品列表
     * @author <a href="hugaoxiang8619@adpanshi.com">hugaoxiang</a>
     */

    List<ProductDataExpansion> selectProductBySortType(@Param("status") byte status, @Param("sort") byte sort);

    /**
     * @return
     * @Description app端查询固定排序产品列表
     * @author <a href="hugaoxiang8619@adpanshi.com">hugaoxiang</a>
     */
    List<ProductDataExpansion> selectFixedPositionProductList();

    /**
     * @return
     * @Description APP获得产品详细信息
     * @author <a href="hugaoxiang8619@adpanshi.com">hugaoxiang</a>
     */
    ProductDetail getProductDataDetail(@Param("id") Integer id, @Param("isHotProduct") boolean isHotProduct);

    /**
     * @return
     * @Description Admin获得产品详细信息
     * @author <a href="hugaoxiang8619@adpanshi.com">hugaoxiang</a>
     */
    ProductDetail getProductDataDetailByAdmin(@Param("id") Integer id);

    /**
     * @return
     * @Description 查询产品列表
     * @author <a href="hugaoxiang8619@adpanshi.com">hugaoxiang</a>
     */
//    List<ProductDetail> selectProductListWithRowbounds(@Param("sqlWhere") ProductSearchRequest params,
//                                                       PageBounds pageBounds);

    /**
     * @return
     * @Description admin端查询固定排序产品列表
     * @author <a href="hugaoxiang8619@adpanshi.com">hugaoxiang</a>
     */
    List<ProductDetail> selectActiveAdminFixedPositionProductList(@Param("sqlWhere") ProductSearchRequest params);

    /**
     * @return
     * @Description admin端查询非固定排序产品+固定非上线产品列表
     * @author <a href="hugaoxiang8619@adpanshi.com">hugaoxiang</a>
     */
    List<ProductDetail> selectAdminUnfixedPositionProductList(@Param("sqlWhere") ProductSearchRequest params);

    /**
     * @Description
     * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
     */
    List<ProductDataExpansion> selectBySort(@Param("sqlWhere") ProductListRequest request, @Param("page") Page page);

    /**
     * @param request
     * @Description
     * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
     */
    long selectBySortCount(@Param("sqlWhere") ProductListRequest request);

    /**
     * @Description
     * @author <a href="chenzuozhou@adpanshi.com">chenzuozhou</a>
     */
    List<PProductStaticUV> staticProductUV(@Param("productIds") List<Integer> productIds, @Param("eventTypes") List<Byte> eventTypes);

    List<AOProductListResponse> aoProductList(@Param("sqlWhere") AOProductListRequest params, @Param("page") Page page);

    long aoProductListCount(@Param("sqlWhere") AOProductListRequest params);

    /**
     * 产品管理-爆款列表
     *
     * @param request
     * @param page
     * @return
     */
    List<AOProductHotListResponse> aoProductHotList(@Param("sqlWhere") AOProductHotListRequest request, @Param("page") Page page);

    /**
     * 产品管理-爆款列表计数
     *
     * @param request
     * @return
     */
    long aoProductHotListCount(@Param("sqlWhere") AOProductHotListRequest request);
}