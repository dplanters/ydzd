/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.admin.controller.admin.product;

import com.gndc.admin.mappers.ProductSystemConfigMapping;
import com.gndc.admin.service.product.productsystemconfig.ProductSystemConfigService;
import com.gndc.common.api.ResponseMessage;
import com.gndc.common.api.admin.systemconfig.AOSystemConfigAddRequest;
import com.gndc.common.api.admin.systemconfig.AOSystemConfigGetByIdRequest;
import com.gndc.common.api.admin.systemconfig.AOSystemConfigUpdateRequest;
import com.gndc.common.enums.system.SystemConfigGroupKeyEnum;
import com.gndc.common.model.SystemConfig;
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
@RequestMapping("/productSystemConfig")
public class ProductSystemConfigController {

    @Autowired
    private ProductSystemConfigService systemConfigService;
    @Autowired
    private ProductSystemConfigMapping productSystemConfigMapping;


    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody @Validated AOSystemConfigAddRequest request){
        ResponseMessage responseMessage=new ResponseMessage();
        SystemConfig systemConfig = productSystemConfigMapping.convert(request);
        systemConfig.setGroup(SystemConfigGroupKeyEnum.PRODUCT.getCode()+":"+request.getProductId());
        systemConfig.setOperatorId(request.getAoAdmin().getId());
        systemConfigService.insert(systemConfig);
        return responseMessage;
    }


    @PostMapping("/updateById")
    public ResponseMessage update(@RequestBody @Validated AOSystemConfigUpdateRequest request){
        ResponseMessage responseMessage=new ResponseMessage();
        SystemConfig systemConfig = productSystemConfigMapping.convert(request);
        systemConfig.setOperatorId(request.getAoAdmin().getId());
        systemConfigService.updateByPrimaryKeySelective(systemConfig);
        return responseMessage;
    }

    @PostMapping("/get/{id}")
    public ResponseMessage<SystemConfig> getById(@PathVariable Integer id){
        ResponseMessage responseMessage=new ResponseMessage();
        SystemConfig systemConfig = systemConfigService.selectByPrimaryKey(id);
        responseMessage.setData(systemConfig);
        return responseMessage;
    }

    @PostMapping("/getById")
    public ResponseMessage<SystemConfig> getById(@RequestBody @Validated AOSystemConfigGetByIdRequest request){
        ResponseMessage responseMessage=new ResponseMessage();
        SystemConfig systemConfig = systemConfigService.selectByPrimaryKey(request.getId());
        responseMessage.setData(systemConfig);
        return responseMessage;
    }

}
