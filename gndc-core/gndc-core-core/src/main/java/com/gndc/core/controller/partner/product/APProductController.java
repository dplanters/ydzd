package com.gndc.core.controller.partner.product;

import com.gndc.common.api.ResponseMessage;
import com.gndc.core.api.partner.product.APProductListRequest;
import com.gndc.core.api.partner.product.APProductListResponse;
import com.gndc.core.service.product.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/partner/product")
public class APProductController {

    @Autowired
    private ProductService productService;

    /**
     * 获取产品列表
     * @param request
     * @return
     */
    @PostMapping("/productList")
    public ResponseMessage<List<APProductListResponse>> productList(@Validated @RequestBody APProductListRequest request) {
        ResponseMessage<List<APProductListResponse>> response = new ResponseMessage<>();

        List<APProductListResponse> apProductListResponses = productService.productList(request);

        response.setData(apProductListResponses);
        return response;
    }

}