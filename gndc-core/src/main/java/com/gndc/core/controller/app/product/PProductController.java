package com.gndc.core.controller.app.product;

import com.gndc.core.api.common.ResponseMessage;
import com.gndc.core.api.app.product.hot.PHotProductResponse;
import com.gndc.core.api.common.CommonRequest;
import com.gndc.core.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 客户端产品相关
 */
@RestController
@RequestMapping("/product")
public class PProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/hot/productList")
    public ResponseMessage<List<PHotProductResponse>> hotProductList(CommonRequest commonRequest) {
        ResponseMessage<List<PHotProductResponse>> response = new ResponseMessage<>();
        List<PHotProductResponse> pHotProductList = productService.selectPHotProductList(commonRequest);
        response.setData(pHotProductList);
        return response;
    }


}
