/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.mappers;

import com.gndc.core.api.admin.partner.AOPartnerApiAddRequest;
import com.gndc.core.api.admin.partner.AOPartnerApiDeleteRequest;
import com.gndc.core.api.admin.partner.AOPartnerApiListRequest;
import com.gndc.core.api.admin.partner.AOPartnerApiModifyRequest;
import com.gndc.core.model.Partner;
import com.gndc.core.model.PartnerApi;
import org.mapstruct.Mapper;

/**
 * @author <a href="liujun8852@adpanshi.com">liujun</a>
 * @version V1.0.1
 * @Description
 * @date 2019/4/15  11:32
 */
@Mapper(componentModel = "spring")
public interface PartnerApiMapping {

    PartnerApi toEntity(AOPartnerApiAddRequest aoPartnerApiAddRequest);
    PartnerApi toEntity(AOPartnerApiDeleteRequest aoPartnerApiDeleteRequest);
    PartnerApi toEntity(AOPartnerApiModifyRequest aoPartnerApiModifyRequest);
    PartnerApi toEntity(AOPartnerApiListRequest aoPartnerApiListRequest);

}
