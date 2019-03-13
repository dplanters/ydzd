package com.gndc.core.controller.admin;

import com.github.pagehelper.PageInfo;
import com.gndc.common.api.ResponseMessage;
import com.gndc.common.enums.common.DelType;
import com.gndc.common.enums.product.ProductStatus;
import com.gndc.core.api.admin.product.*;
import com.gndc.core.model.Product;
import com.gndc.core.service.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.weekend.Weekend;

import java.util.List;

@RestController
@RequestMapping("/admin/product")
public class AOProductController {

    private static final Logger logger = LoggerFactory.getLogger(AOProductController.class);

    @Autowired
    private ProductService productService;

    
    @PostMapping("/productList")
    public ResponseMessage<List<AOProductListResponse>> productList(@Validated @RequestBody AOProductListRequest request) {
        ResponseMessage<List<AOProductListResponse>> response = new ResponseMessage<>();
        List<AOProductListResponse> aoProductListResponses = productService.productList(request);
        PageInfo<AOProductListResponse> pageInfo = new PageInfo<>(aoProductListResponses);

        response.setData(aoProductListResponses);
        response.setPage(pageInfo);

        return response;
    }

    @PostMapping("/productNameAll")
    public ResponseMessage<List<Product>> productNameAll(@Validated @RequestBody AOAllProductNameRequest request) {
        ResponseMessage<List<Product>> response = new ResponseMessage<>();

        Weekend<Product> weekend = Weekend.of(Product.class);
        weekend.selectProperties("id", "name");
        weekend.weekendCriteria()
                .andEqualTo(Product::getIsDel, DelType.NORMAL.getCode())
                .andEqualTo(Product::getStatus, ProductStatus.ON_LINE.getCode());

        Integer partnerId = request.getPartnerId();
        if (partnerId != null) {
            weekend.weekendCriteria().andEqualTo(Product::getPartnerId, partnerId);
            weekend.and();
        }

        List<Product> products = productService.selectByExample(weekend);

        response.setData(products);

        return response;
    }

    @PostMapping("/aoProductAddModify")
    public ResponseMessage<Integer> productAddModify(@Validated @RequestBody AOProductAddModifyRequest request) {
        ResponseMessage<Integer> response = new ResponseMessage<>();

        Integer id = productService.productAddModify(request);

        response.setData(id);
        return response;
    }

    @PostMapping("/productDetail")
    public ResponseMessage<AOProductDetailResponse> productDetail(@Validated @RequestBody AOProductDetailRequest request) {
        ResponseMessage<AOProductDetailResponse> response = new ResponseMessage<>();

        AOProductDetailResponse aoProductDetailResponse = productService.productDetail(request);
        response.setData(aoProductDetailResponse);
        return response;
    }

    @PostMapping("/aoProductUpperAndLowerLine")
    public ResponseMessage<Boolean> productUpperAndLowerLine(@Validated @RequestBody AOUpperAndLowerLineRequest request) {
        ResponseMessage<Boolean> response = new ResponseMessage<>();
        Boolean success = productService.productUpperAndLowerLine(request);
        response.setData(success);
        return response;
    }

    @PostMapping("/productDelete")
    public ResponseMessage<Boolean> productDelete(@Validated @RequestBody AOProductDeleteRequest request) {
        ResponseMessage<Boolean> response = new ResponseMessage<>();
        Boolean success = productService.productDelete(request);
        response.setData(success);
        return response;
    }

    @PostMapping("/productHotList")
    public ResponseMessage<List<AOProductHotListResponse>> productHotList(@Validated @RequestBody AOProductHotListRequest request) {
        ResponseMessage<List<AOProductHotListResponse>> response = new ResponseMessage<>();

        List<AOProductHotListResponse> aoProductHotListResponses = productService.productHotList(request);

        PageInfo<AOProductHotListResponse> pageInfo = new PageInfo<>(aoProductHotListResponses);
        response.setPage(pageInfo);
        response.setData(aoProductHotListResponses);

        return response;
    }

    @PostMapping("/productHotEdit")
    @Transactional
    public ResponseMessage<Integer> productHotEdit(@Validated @RequestBody AOProductHotEditRequest request) {
        ResponseMessage<Integer> response = new ResponseMessage<>();

        Integer id = productService.productHotEdit(request);

        response.setData(id);
        return response;
    }
}
