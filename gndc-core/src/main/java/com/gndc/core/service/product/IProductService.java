package com.gndc.core.service.product;

import com.gndc.common.api.ResponseMessage;
import com.gndc.core.api.product.AOProductDetailResponse;
import com.gndc.core.api.product.AOProductHotListResponse;
import com.gndc.core.api.product.AOProductListResponse;
import com.gndc.core.api.product.APProductListResponse;
import com.gndc.core.model.Product;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IProductService {

    /**
     * 商户后台-获取产品列表
     * @param requestStr
     * @return
     */
    ResponseMessage<List<APProductListResponse>> apProductList(@RequestParam String requestStr);

    /**
     * 运营后台-产品管理-获取产品列表
     * @param requestStr
     * @return
     */
    ResponseMessage<List<AOProductListResponse>> aoProductList(@RequestParam String requestStr);

    /**
     * 运营后台-获取所有产品名
     * @param requestStr
     * @return
     */
    ResponseMessage<List<Product>> aoProductNameAll(@RequestParam String requestStr);

    /**
     * 运营后台-产品管理-产品添加
     * @param requestStr
     * @return
     */
    ResponseMessage<Integer> aoProductAddModify(@RequestParam String requestStr);

    /**
     * 运营后台-产品管理-获取产品详情
     * @param requestStr
     * @return
     */
    ResponseMessage<AOProductDetailResponse> aoProductDetail(@RequestParam String requestStr);

    /**
     * 运营后台-产品管理-产品上下线
     * @param requestStr
     * @return
     */
    ResponseMessage<Boolean> aoProductUpperAndLowerLine(@RequestParam String requestStr);

    /**
     * 运营后台-产品管理-产品删除
     * @param requestStr
     * @return
     */
    ResponseMessage<Boolean> aoProductDelete(@RequestParam String requestStr);
    /**
     * 运营后台-产品管理-精选爆款列表
     * @param requestStr
     * @return
     */
    ResponseMessage<List<AOProductHotListResponse>> aoProductHotList(@RequestParam String requestStr);
    /**
     * 运营后台-产品管理-精选爆款编辑
     * @param requestStr
     * @return
     */
    ResponseMessage<Integer> aoProductHotEdit(@RequestParam String requestStr);
}
