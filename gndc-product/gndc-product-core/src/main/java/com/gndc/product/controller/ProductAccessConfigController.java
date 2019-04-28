/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.product.controller;

import com.gndc.api.product.productaccessconfig.ProductAccessConfigAddRquest;
import com.gndc.api.product.productaccessconfig.ProductAccessConfigUpdateRquest;
import com.gndc.common.api.ResponseMessage;
import com.gndc.product.mappers.ProductAccessConfigMapping;
import com.gndc.product.model.ProductAccessConfig;
import com.gndc.product.service.ProductAccessConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/productAccessConfig")
public class ProductAccessConfigController {

    @Autowired
    private ProductAccessConfigService productAccessConfigService;
    @Autowired
    private ProductAccessConfigMapping productAccessConfigMapping;


    @PostMapping("/insert")
    public ResponseMessage insert(ProductAccessConfigAddRquest request){
        ResponseMessage responseMessage=new ResponseMessage();
        ProductAccessConfig productAccessConfig = productAccessConfigMapping.convert(request);
        productAccessConfigService.insert(productAccessConfig);
        return responseMessage;
    }

    @PostMapping("/updateById")
    public ResponseMessage updateById(ProductAccessConfigUpdateRquest request){
        ResponseMessage responseMessage=new ResponseMessage();
        ProductAccessConfig productAccessConfig = productAccessConfigMapping.convert(request);
        productAccessConfigService.updateByPrimaryKeySelective(productAccessConfig);
        return responseMessage;
    }

}
