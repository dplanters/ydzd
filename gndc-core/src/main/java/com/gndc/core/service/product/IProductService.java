package com.gndc.core.service.product;

import com.gndc.common.api.HjException;
import com.gndc.common.api.ResponseMessage;
import com.gndc.common.service.BaseService;
import com.gndc.core.api.admin.product.*;
import com.gndc.core.api.partner.product.APProductListRequest;
import com.gndc.core.api.partner.product.APProductListResponse;
import com.gndc.core.model.Product;
import java.util.List;

public interface IProductService extends BaseService<Product, Integer> {

    /**
     * 商户后台-获取产品列表
     * @return
     */
    ResponseMessage<List<APProductListResponse>> productList(APProductListRequest request);

    /**
     * 运营后台-产品管理-获取产品列表
     * @return
     */
    ResponseMessage<List<AOProductListResponse>> productList(AOProductListRequest request);

    /**
     * 运营后台-获取所有产品名
     * @return
     */
    ResponseMessage<List<Product>> productNameAll(AOAllProductNameRequest request);

    /**
     * 运营后台-产品管理-产品添加
     * @return
     */
    ResponseMessage<Integer> productAddModify(AOProductAddModifyRequest request);

    /**
     * 运营后台-产品管理-获取产品详情
     * @return
     */
    ResponseMessage<AOProductDetailResponse> productDetail(AOProductDetailRequest request);

    /**
     * 运营后台-产品管理-产品上下线
     * @return
     */
    ResponseMessage<Boolean> productUpperAndLowerLine(AOUpperAndLowerLineRequest request);

    /**
     * 运营后台-产品管理-产品删除
     * @return
     */
    ResponseMessage<Boolean> productDelete(AOProductDeleteRequest request);
    /**
     * 运营后台-产品管理-精选爆款列表
     * @return
     */
    ResponseMessage<List<AOProductHotListResponse>> productHotList(AOProductHotListRequest request);
    /**
     * 运营后台-产品管理-精选爆款编辑
     * @return
     */
    ResponseMessage<Integer> productHotEdit(AOProductHotEditRequest request) throws HjException;
}
