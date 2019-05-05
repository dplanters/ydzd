/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.admin.service.product;

import com.gndc.common.api.admin.product.AOProductSearchRequest;
import com.gndc.common.dto.ProductListDTO;
import com.gndc.common.mapper.ProductMapper;
import com.gndc.common.model.Product;
import com.gndc.common.service.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="liujun8852@adpanshi.com">liujun</a>
 * @version V1.0.1
 * @Description
 * @date 2019/4/27  14:55
 */
@Slf4j
@Service
public class ProductServiceImpl extends BaseServiceImpl<Product,Integer> implements ProductService {

    @Autowired
    private ProductMapper productMapper;


    @Override
    public List<ProductListDTO> selectProduct(AOProductSearchRequest param){
        return productMapper.selectProduct(param);
    }


}
