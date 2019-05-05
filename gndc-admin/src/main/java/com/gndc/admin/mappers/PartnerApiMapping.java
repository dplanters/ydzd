/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.admin.mappers;

import com.gndc.admin.api.admin.partner.AOPartnerApiAddRequest;
import com.gndc.admin.api.admin.partner.AOPartnerApiDeleteRequest;
import com.gndc.admin.api.admin.partner.AOPartnerApiListRequest;
import com.gndc.admin.api.admin.partner.AOPartnerApiModifyRequest;
import com.gndc.common.model.PartnerApi;
import org.mapstruct.Mapper;

/**
 * @author <a href="liujun8852@adpanshi.com">liujun</a>
 * @version V1.0.1
 * @Description
 * @date 2019/4/15  11:32
 */
@Mapper(componentModel = "spring")
public interface PartnerApiMapping {

    PartnerApi convert(AOPartnerApiAddRequest aoPartnerApiAddRequest);

    PartnerApi convert(AOPartnerApiDeleteRequest aoPartnerApiDeleteRequest);

    PartnerApi convert(AOPartnerApiModifyRequest aoPartnerApiModifyRequest);

    PartnerApi convert(AOPartnerApiListRequest aoPartnerApiListRequest);

}
