package com.gndc.core.service.product;

import com.gndc.common.exception.HjException;
import com.gndc.common.service.BaseService;
import com.gndc.core.api.admin.product.*;
import com.gndc.core.api.app.product.hot.PHotProductResponse;
import com.gndc.core.api.common.CommonRequest;
import com.gndc.core.api.partner.product.APProductListRequest;
import com.gndc.core.api.partner.product.APProductListResponse;
import com.gndc.core.model.Product;
import java.util.List;

public interface ProductService extends BaseService<Product, Integer> {

    /**
     * 商户后台-获取产品列表
     * @return
     */
    List<APProductListResponse> productList(APProductListRequest request);

    /**
     * 运营后台-产品管理-获取产品列表
     * @return
     */
    List<AOProductListResponse> productList(AOProductListRequest request);

    /**
     * 运营后台-产品管理-产品添加
     * @return
     */
    Integer productAddModify(AOProductAddModifyRequest request);

    /**
     * 运营后台-产品管理-获取产品详情
     * @return
     */
    AOProductDetailResponse productDetail(AOProductDetailRequest request);

    /**
     * 运营后台-产品管理-产品上下线
     * @return
     */
    Boolean productUpperAndLowerLine(AOUpperAndLowerLineRequest request);

    /**
     * 运营后台-产品管理-产品删除
     * @return
     */
    Boolean productDelete(AOProductDeleteRequest request);
    /**
     * 运营后台-产品管理-精选爆款列表
     * @return
     */
    List<AOProductHotListResponse> productHotList(AOProductHotListRequest request);
    /**
     * 运营后台-产品管理-精选爆款编辑
     * @return
     */
    Integer productHotEdit(AOProductHotEditRequest request) throws HjException;
    /**
     * 客户端-首页-精选爆款列表
     * @return
     */
    List<PHotProductResponse> selectPHotProductList(CommonRequest commonRequest);
}
