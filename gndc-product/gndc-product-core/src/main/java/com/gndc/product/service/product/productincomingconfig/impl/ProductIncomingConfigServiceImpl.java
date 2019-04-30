/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.product.service.product.productincomingconfig.impl;

import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.product.api.admin.product.productincomingconfig.AOProductIncomingConfigSearchRequest;
import com.gndc.product.mapper.ProductIncomingConfigMapper;
import com.gndc.product.model.ProductIncomingConfig;
import com.gndc.product.service.product.productincomingconfig.ProductIncomingConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="liujun8852@adpanshi.com">liujun</a>
 * @version V1.0.1
 * @Description
 * @date 2019/4/28  9:14
 */
@Slf4j
@Service
public class ProductIncomingConfigServiceImpl extends BaseServiceImpl<ProductIncomingConfig,Integer> implements ProductIncomingConfigService {

    @Autowired
    private ProductIncomingConfigMapper productIncomingConfigMapper;

    @Override
    public List<Object> selectProductIncomingConfigPage(AOProductIncomingConfigSearchRequest param) {

        return null;
    }
}
