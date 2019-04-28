/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.product.controller;

import com.gndc.api.product.ProductAddRequest;
import com.gndc.api.product.ProductUpdateRequest;
import com.gndc.common.api.ResponseMessage;
import com.gndc.product.mappers.ProductMapping;
import com.gndc.product.model.Product;
import com.gndc.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
    private ProductMapping productMapping;


    @PostMapping("/insert")
    public ResponseMessage insert(@Validated ProductAddRequest request){
        ResponseMessage responseMessage=new ResponseMessage();
        Product product = productMapping.convert(request);
        productService.insert(product);
        return responseMessage;
    }


    @PostMapping("/updateById")
    public ResponseMessage update(@Validated ProductUpdateRequest request){
        ResponseMessage responseMessage=new ResponseMessage();
        Product product = productMapping.convert(request);
        productService.updateByPrimaryKeySelective(product);
        return responseMessage;
    }

}
