/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.product.service.product.productshowconfig.impl;

import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.product.api.admin.product.productshowconfig.AOProductShowConfigAddRequest;
import com.gndc.product.mappers.ProductShowConfigMapping;
import com.gndc.product.model.ProductFilterLabel;
import com.gndc.product.model.ProductShowConfig;
import com.gndc.product.service.product.productfilterlabel.ProductFilterLabelService;
import com.gndc.product.service.product.productshowconfig.ProductShowConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;

import java.util.List;

/**
 * @author <a href="liujun8852@adpanshi.com">liujun</a>
 * @version V1.0.1
 * @Description
 * @date 2019/4/28  9:14
 */
@Slf4j
@Service
public class ProductShowConfigServiceImpl extends BaseServiceImpl<ProductShowConfig,Integer> implements ProductShowConfigService {

    @Autowired
    private ProductShowConfigMapping productShowConfigMapping;
    @Autowired
    private ProductFilterLabelService productFilterLabelService;

    @Override
    public void insert(AOProductShowConfigAddRequest request) {
        Integer adminId = request.getAoAdmin().getId();
        String[] labels = request.getLabels();
        //先插入筛选标签
        if(labels!=null&&labels.length>0){
            ProductFilterLabel productFilterLabel=new ProductFilterLabel();
            productFilterLabel.setOperatorId(adminId);
            productFilterLabel.setProductId(request.getProductId());
            productFilterLabelService.insert(productFilterLabel);
        }

        ProductShowConfig productShowConfig = productShowConfigMapping.convert(request);
        productShowConfig.setOperatorId(adminId);
        this.insert(productShowConfig);

        //排序位置更改，只更改属于同一个模块同一个渠道的
        Weekend<ProductShowConfig> weekend=new Weekend(ProductShowConfig.class);
        weekend.weekendCriteria()
                .andGreaterThan(ProductShowConfig::getShowPosition,productShowConfig.getShowPosition())
                .andEqualTo(ProductShowConfig::getChannelId,productShowConfig.getChannelId())
                .andEqualTo(ProductShowConfig::getShowModule,productShowConfig.getShowModule());
        List<ProductShowConfig> productShowConfigs = this.selectByExample(weekend);
        if(productShowConfigs!=null&&productShowConfigs.isEmpty()){
            productShowConfigs.forEach(x->{
                int i = x.getShowPosition() + Byte.valueOf("1");
                x.setShowPosition((byte)i);
                this.updateByPrimaryKey(x);
            });
        }
    }
}
