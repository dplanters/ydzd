/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.product.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gndc.common.api.ResponseMessage;
import com.gndc.common.enums.common.StatusEnum;
import com.gndc.product.api.product.ProductAddRequest;
import com.gndc.product.api.product.ProductSearchRequest;
import com.gndc.product.api.product.ProductUpdateRequest;
import com.gndc.product.dto.ProductInfoDTO;
import com.gndc.product.dto.ProductListDTO;
import com.gndc.product.mappers.ProductMapping;
import com.gndc.product.model.Product;
import com.gndc.product.model.ProductAccessConfig;
import com.gndc.product.model.SystemConfig;
import com.gndc.product.service.ProductAccessConfigService;
import com.gndc.product.service.ProductService;
import com.gndc.product.service.ProductSystemConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author <a href="liujun8852@adpanshi.com">liujun</a>
 * @version V1.0.1
 * @Description
 * @date 2019/4/27  14:58
 */
@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductAccessConfigService productAccessConfigService;
    @Autowired
    private ProductSystemConfigService systemConfigService;
    @Autowired
    private ProductMapping productMapping;


    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody @Validated ProductAddRequest request){
        ResponseMessage responseMessage=new ResponseMessage();
        //todo productId  生成策略待确认
        Product product = productMapping.convert(request);
        product.setOperatorId(request.getAoAdmin().getId());
        productService.insert(product);
        return responseMessage;
    }


    @PostMapping("/updateById")
    public ResponseMessage update(@RequestBody @Validated ProductUpdateRequest request){
        ResponseMessage responseMessage=new ResponseMessage();
        Product product = productMapping.convert(request);
        product.setOperatorId(request.getAoAdmin().getId());
        productService.updateByPrimaryKeySelective(product);
        return responseMessage;
    }

    @PostMapping("/delete/{id}")
    public ResponseMessage delete(@PathVariable Integer id){
        ResponseMessage responseMessage=new ResponseMessage();
        Product product = new Product();
        product.setId(id);
        product.setStatus(StatusEnum.DELETE.getCode());
        productService.updateByPrimaryKeySelective(product);
        return responseMessage;
    }

    @PostMapping("/get/{id}")
    public ResponseMessage<Product> getById(@PathVariable Integer id){
        ResponseMessage responseMessage=new ResponseMessage();
        Product product = productService.selectByPrimaryKey(id);
        responseMessage.setData(product);
        return responseMessage;
    }



    /**
     * 根据产品主键id 获取产品详情
     * @Description
     * @author <a href="liujun8852@adpanshi.com">liujun</a>
     */
    @PostMapping("/getProductInfo/{id}")
    public ResponseMessage<ProductInfoDTO> getProductInfo(@PathVariable Integer id){
        ResponseMessage<ProductInfoDTO> responseMessage=new ResponseMessage<ProductInfoDTO>();
        Product product = productService.selectByPrimaryKey(id);

        List<SystemConfig> systemConfigs = systemConfigService.selectByProperty(SystemConfig::getGroup,id);

        ProductAccessConfig productAccessConfig = productAccessConfigService.selectOneByProperty(ProductAccessConfig::getProductId,id);

        ProductInfoDTO productInfoDTO=new ProductInfoDTO();
        productInfoDTO.setProduct(product);
        productInfoDTO.setSystemConfig(systemConfigs);
        productInfoDTO.setProductAccessConfig(productAccessConfig);

        responseMessage.setData(productInfoDTO);
        return responseMessage;
    }



    /**
     * 根据产品主键id 获取产品详情
     * @Description
     * @author <a href="liujun8852@adpanshi.com">liujun</a>
     */
    @PostMapping("/selectProductPage")
    public ResponseMessage<List<ProductListDTO>> selectProductInfoPage(@RequestBody ProductSearchRequest request){

        ResponseMessage<List<ProductListDTO>> responseMessage=new ResponseMessage<List<ProductListDTO>>();

        PageHelper.startPage(request.getPageNum(), request.getPageSize());

        List<ProductListDTO> productListDTOS = productService.selectProduct(request);

        PageInfo pageInfo=new PageInfo();
        responseMessage.setPage(pageInfo);
        responseMessage.setData(productListDTOS);
        return responseMessage;
    }


}
