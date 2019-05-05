/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.admin.controller.admin.product;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gndc.admin.mappers.ProductShowConfigMapping;
import com.gndc.admin.service.product.productfilterlabel.ProductFilterLabelService;
import com.gndc.admin.service.product.productshowconfig.ProductShowConfigService;
import com.gndc.common.api.ResponseMessage;
import com.gndc.common.api.admin.product.productshowconfig.*;
import com.gndc.common.dto.ProductShowConfigListDTO;
import com.gndc.common.enums.common.StatusEnum;
import com.gndc.common.model.ProductFilterLabel;
import com.gndc.common.model.ProductShowConfig;
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
@RequestMapping("/productShowConfig")
public class ProductShowConfigController {

    @Autowired
    private ProductShowConfigService productShowConfigService;
    @Autowired
    private ProductShowConfigMapping productShowConfigMapping;
    @Autowired
    private ProductFilterLabelService productFilterLabelService;


    @PostMapping("/insert")
    public ResponseMessage insert(@RequestBody @Validated AOProductShowConfigAddRequest request){
        ResponseMessage responseMessage=new ResponseMessage();
        productShowConfigService.insert(request);
        return responseMessage;
    }

    @PostMapping("/update")
    public ResponseMessage update(@RequestBody @Validated AOProductShowConfigUpdateRequest request){
        ResponseMessage responseMessage=new ResponseMessage();
        productShowConfigService.update(request);
        return responseMessage;
    }

    @PostMapping("/getLable/{productId}")
    public ResponseMessage getLable(@PathVariable Integer productId){
        ResponseMessage responseMessage=new ResponseMessage();
        List<ProductFilterLabel> productFilterLabels = productFilterLabelService.selectByProperty(ProductFilterLabel::getProductId, productId);
        responseMessage.setData(productFilterLabels);
        return responseMessage;
    }

    @PostMapping("/updateOnlineStatus")
    public ResponseMessage updateOnlineStatus(@RequestBody @Validated AOProductShowConfigUpdateOnLineStatusRequest request){
        ResponseMessage responseMessage=new ResponseMessage();
        ProductShowConfig productShowConfig= productShowConfigMapping.convert(request);
        productShowConfigService.updateByPrimaryKeySelective(productShowConfig);
        return responseMessage;
    }

    @PostMapping("/delete")
    public ResponseMessage delete(@RequestBody @Validated AOProductShowConfigDeleteRequest request){
        ResponseMessage responseMessage=new ResponseMessage();
        ProductShowConfig productShowConfig = new ProductShowConfig();
        productShowConfig.setId(request.getId());
        productShowConfig.setStatus(StatusEnum.DELETE.getCode());
        productShowConfigService.updateByPrimaryKeySelective(productShowConfig);
        return responseMessage;
    }

    @PostMapping("/selectProductShowConfigPage")
    public ResponseMessage selectProductShowConfigPage(@RequestBody @Validated AOProductShowConfigSearchRequest request){
        ResponseMessage responseMessage=new ResponseMessage();
        PageHelper.startPage(request.getPageNum(),request.getPageSize());
        List<ProductShowConfigListDTO> data = productShowConfigService.selectProductShowConfigPage(request);
        PageInfo<ProductShowConfigListDTO> pageInfo=new PageInfo<>(data);
        responseMessage.setData(data);
        responseMessage.setPage(pageInfo);
        return responseMessage;
    }
}
