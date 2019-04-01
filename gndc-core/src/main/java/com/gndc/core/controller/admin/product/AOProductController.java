package com.gndc.core.controller.admin.product;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gndc.common.enums.common.OnlineStatusEnum;
import com.gndc.common.api.ResponseMessage;
import com.gndc.common.enums.common.StatusEnum;
import com.gndc.core.api.admin.product.*;
import com.gndc.core.model.Product;
import com.gndc.core.service.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 产品列表
     * @param request
     * @return
     */
    @PostMapping("/productList")
    public ResponseMessage<List<AOProductListResponse>> productList(@Validated @RequestBody AOProductListRequest request) {
        ResponseMessage<List<AOProductListResponse>> response = new ResponseMessage<>();
        PageInfo page = request.getHeader().getPage();

        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<AOProductListResponse> aoProductListResponses = productService.productList(request);
        PageInfo<AOProductListResponse> pageInfo = new PageInfo<>(aoProductListResponses);

        response.setData(aoProductListResponses);
        response.setPage(pageInfo);

        return response;
    }

    /**
     * 产品名列表（精选爆款下拉框数据初始化接口）
     * @param request
     * @return
     */
    @PostMapping("/productNameAll")
    public ResponseMessage<List<Product>> productNameAll(@Validated @RequestBody AOAllProductNameRequest request) {
        ResponseMessage<List<Product>> response = new ResponseMessage<>();

        Weekend<Product> weekend = Weekend.of(Product.class);
        weekend.selectProperties("id", "name");
        weekend.weekendCriteria()
                .andEqualTo(Product::getStatus, StatusEnum.NORMAL.getCode())
                .andEqualTo(Product::getProductStatus, OnlineStatusEnum.ONLINE.getCode())
                .andEqualTo(Product::getPartnerId, request.getPartnerId());

        List<Product> products = productService.selectByExample(weekend);

        response.setData(products);

        return response;
    }

    /**
     * 添加产品
     * @param request
     * @return
     */
    @PostMapping("/addProduct")
    public ResponseMessage<Integer> addProduct(@Validated @RequestBody AOProductAddRequest request) {
        ResponseMessage<Integer> response = new ResponseMessage<>();

        Integer id = productService.addProduct(request);

        response.setData(id);
        return response;
    }

    /**
     * 修改产品
     * @param request
     * @return
     */
    @PostMapping("/modifyProduct")
    public ResponseMessage<Integer> modifyProduct(@Validated @RequestBody AOProductModifyRequest request) {
        ResponseMessage<Integer> response = new ResponseMessage<>();

        Integer id = productService.modifyProduct(request);

        response.setData(id);
        return response;
    }

    /**
     * 获取产品详情
     * @param request
     * @return
     */
    @PostMapping("/productDetail")
    public ResponseMessage<AOProductDetailResponse> productDetail(@Validated @RequestBody AOProductDetailRequest request) {
        ResponseMessage<AOProductDetailResponse> response = new ResponseMessage<>();

        AOProductDetailResponse aoProductDetailResponse = productService.productDetail(request);
        response.setData(aoProductDetailResponse);
        return response;
    }

    /**
     * 产品上下线
     * @param request
     * @return
     */
    @PostMapping("/productUpperAndLowerLine")
    public ResponseMessage<Boolean> productUpperAndLowerLine(@Validated @RequestBody AOProductOnlineOrOfflineRequest request) {
        ResponseMessage<Boolean> response = new ResponseMessage<>();
        Boolean success = productService.productUpperAndLowerLine(request);
        response.setData(success);
        return response;
    }

    /**
     * 产品删除
     * @param request
     * @return
     */
    @PostMapping("/productDelete")
    public ResponseMessage<Boolean> productDelete(@Validated @RequestBody AOProductDeleteRequest request) {
        ResponseMessage<Boolean> response = new ResponseMessage<>();
        Boolean success = productService.productDelete(request);
        response.setData(success);
        return response;
    }

    /**
     * 获取爆款产品列表
     * @param request
     * @return
     */
    @PostMapping("/productHotList")
    public ResponseMessage<List<AOProductHotListResponse>> productHotList(@Validated @RequestBody AOProductHotListRequest request) {
        ResponseMessage<List<AOProductHotListResponse>> response = new ResponseMessage<>();
        PageInfo page = request.getHeader().getPage();

        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<AOProductHotListResponse> aoProductHotListResponses = productService.productHotList(request);

        PageInfo<AOProductHotListResponse> pageInfo = new PageInfo<>(aoProductHotListResponses);
        response.setPage(pageInfo);
        response.setData(aoProductHotListResponses);

        return response;
    }

    /**
     * 爆款产品添加
     * @param request
     * @return
     */
    @PostMapping("/addProductHot")
    @Transactional
    public ResponseMessage<Integer> productHotEdit(@Validated @RequestBody AOProductHotAddRequest request) {
        ResponseMessage<Integer> response = new ResponseMessage<>();

        Integer id = productService.productHotAdd(request);

        response.setData(id);
        return response;
    }

    /**
     * 爆款产品下线
     * @param request
     * @return
     */
    @PostMapping("/productHotOffline")
    @Transactional
    public ResponseMessage<Integer> productHotOffline(@Validated @RequestBody AOProductHotOfflineRequest request) {
        ResponseMessage<Integer> response = new ResponseMessage<>();

        Integer id = productService.productHotOffline(request);

        response.setData(id);
        return response;
    }
}
