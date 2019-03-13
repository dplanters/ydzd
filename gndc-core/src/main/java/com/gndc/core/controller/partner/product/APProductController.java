package com.gndc.core.controller.partner.product;

import com.gndc.common.api.ResponseMessage;
import com.gndc.core.api.partner.product.APProductListRequest;
import com.gndc.core.api.partner.product.APProductListResponse;
import com.gndc.core.service.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/partner/product")
public class APProductController {

    private static final Logger logger = LoggerFactory.getLogger(APProductController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping("/productList")
    public ResponseMessage<List<APProductListResponse>> productList(@Validated @RequestBody APProductListRequest request) {
        ResponseMessage<List<APProductListResponse>> response = new ResponseMessage<>();

        List<APProductListResponse> apProductListResponses = productService.productList(request);

        response.setData(apProductListResponses);
        return response;
    }

}
