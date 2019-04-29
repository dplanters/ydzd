/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.product.api.admin.product;

import com.gndc.common.api.RequestMessage;
import lombok.Data;

/**
 * @author <a href="liujun8852@adpanshi.com">liujun</a>
 * @version V1.0.1
 * @Description
 * @date 2019/4/27  13:54
 */
@Data
public class AOProductSearchRequest extends RequestMessage  {

    private Long productId;
    //产品状态  1：上线；0：下线；
    private String productStatus;
    // 合作机构ID
    private Integer partnerId;
    private String startTime;
    private String endTime;

}
