/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.product.controller;

import com.gndc.common.api.ResponseMessage;
import com.gndc.product.api.admin.product.productaccessconfig.AOProductAccessConfigAddRquest;
import com.gndc.product.api.admin.product.productaccessconfig.AOProductAccessConfigGetByIdRquest;
import com.gndc.product.api.admin.product.productaccessconfig.AOProductAccessConfigUpdateRquest;
import com.gndc.product.mappers.ProductAccessConfigMapping;
import com.gndc.product.model.ProductAccessConfig;
import com.gndc.product.service.product.productaccessconfig.ProductAccessConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


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
    public ResponseMessage insert(@RequestBody @Validated AOProductAccessConfigAddRquest request){
        ResponseMessage responseMessage=new ResponseMessage();
        ProductAccessConfig productAccessConfig = productAccessConfigMapping.convert(request);
        productAccessConfig.setOperatorId(request.getAoAdmin().getId());
        productAccessConfigService.insert(productAccessConfig);
        return responseMessage;
    }

    @PostMapping("/updateById")
    public ResponseMessage updateById(@RequestBody @Validated AOProductAccessConfigUpdateRquest request){
        ResponseMessage responseMessage=new ResponseMessage();
        ProductAccessConfig productAccessConfig = productAccessConfigMapping.convert(request);
        productAccessConfig.setOperatorId(request.getAoAdmin().getId());
        productAccessConfigService.updateByPrimaryKeySelective(productAccessConfig);
        return responseMessage;
    }

    @PostMapping("/get/{id}")
    public ResponseMessage<ProductAccessConfig> getById(@PathVariable Integer id){
        ResponseMessage responseMessage=new ResponseMessage();
        ProductAccessConfig productAccessConfig = productAccessConfigService.selectByPrimaryKey(id);
        responseMessage.setData(productAccessConfig);
        return responseMessage;
    }

    @PostMapping("/getById")
    public ResponseMessage<ProductAccessConfig> getById(@PathVariable AOProductAccessConfigGetByIdRquest request){
        ResponseMessage responseMessage=new ResponseMessage();
        ProductAccessConfig productAccessConfig = productAccessConfigService.selectByPrimaryKey(request.getId());
        responseMessage.setData(productAccessConfig);
        return responseMessage;
    }
}
