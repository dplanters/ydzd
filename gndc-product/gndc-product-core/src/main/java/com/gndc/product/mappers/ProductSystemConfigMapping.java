/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.product.mappers;

import com.gndc.product.api.systemconfig.SystemConfigAddRequest;
import com.gndc.product.api.systemconfig.SystemConfigUpdateRequest;
import com.gndc.product.model.SystemConfig;
import org.mapstruct.Mapper;

/**
 * @author <a href="liujun8852@adpanshi.com">liujun</a>
 * @version V1.0.1
 * @Description
 * @date 2019/4/27  13:52
 */
@Mapper(componentModel = "spring")
public interface ProductSystemConfigMapping {

    SystemConfig convert(SystemConfigAddRequest request);

    SystemConfig convert(SystemConfigUpdateRequest request);

}
