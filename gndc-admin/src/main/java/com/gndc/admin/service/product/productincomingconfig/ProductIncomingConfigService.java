/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.admin.service.product.productincomingconfig;

import com.gndc.common.api.admin.product.productincomingconfig.AOProductIncomingConfigSearchRequest;
import com.gndc.common.dto.ProductIncomingConfigListDTO;
import com.gndc.common.model.ProductIncomingConfig;
import com.gndc.common.service.BaseService;

import java.util.List;

/**
 * @author <a href="liujun8852@adpanshi.com">liujun</a>
 * @version V1.0.1
 * @Description
 * @date 2019/4/28  9:14
 */
public interface ProductIncomingConfigService extends BaseService<ProductIncomingConfig, Integer> {

    /**
     * 列表分页查询
     * @Description
     * @author <a href="liujun8852@adpanshi.com">liujun</a>
     */
    List<ProductIncomingConfigListDTO> selectProductIncomingConfigPage(AOProductIncomingConfigSearchRequest param);

    /**
     * count当天老客进件
     * @param productId 产品id
     * @Description
     * @author <a href="liujun8852@adpanshi.com">liujun</a>
     */
    Integer countSameDayOldGuestsOrder(Integer productId);
    /**
     * count当天新客进件
     * @param productId 产品id
     * @Description
     * @author <a href="liujun8852@adpanshi.com">liujun</a>
     */
    Integer countSameDayNewGuestsOrder(Integer productId);

    /**
     * 新客进件
     * @param productId 产品id
     * @Description
     * @author <a href="liujun8852@adpanshi.com">liujun</a>
     */
    Integer countNewGuests(Integer productId);
    /**
     * 老客进件
     * @param productId 产品id
     * @Description
     * @author <a href="liujun8852@adpanshi.com">liujun</a>
     */
    Integer countOldGuests(Integer productId);
}
