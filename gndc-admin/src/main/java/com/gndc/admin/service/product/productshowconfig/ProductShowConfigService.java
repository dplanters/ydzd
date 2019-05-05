/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.admin.service.product.productshowconfig;

import com.gndc.common.api.admin.product.productshowconfig.AOProductShowConfigAddRequest;
import com.gndc.common.api.admin.product.productshowconfig.AOProductShowConfigSearchRequest;
import com.gndc.common.api.admin.product.productshowconfig.AOProductShowConfigUpdateRequest;
import com.gndc.common.dto.ProductShowConfigListDTO;
import com.gndc.common.model.ProductShowConfig;
import com.gndc.common.service.BaseService;

import java.util.List;

/**
 * @author <a href="liujun8852@adpanshi.com">liujun</a>
 * @version V1.0.1
 * @Description
 * @date 2019/4/28  9:14
 */
public interface ProductShowConfigService extends BaseService<ProductShowConfig, Integer> {

    void insert(AOProductShowConfigAddRequest request);

    void update(AOProductShowConfigUpdateRequest request);

    /**
     * 分页查询
     * @param param
     * @Description
     * @author <a href="liujun8852@adpanshi.com">liujun</a>
     */
    List<ProductShowConfigListDTO> selectProductShowConfigPage(AOProductShowConfigSearchRequest param);

}
