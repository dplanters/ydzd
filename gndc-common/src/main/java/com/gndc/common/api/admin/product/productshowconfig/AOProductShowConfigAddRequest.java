/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.api.admin.product.productshowconfig;

import com.gndc.common.api.RequestMessage;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author <a href="liujun8852@adpanshi.com">liujun</a>
 * @version V1.0.1
 * @Description
 * @date 2019/4/29  14:58
 */
@Data
public class AOProductShowConfigAddRequest extends RequestMessage implements Serializable {

    /**
     * 产品id
     */
    @NotNull
    private Integer productId;
    /**
     * 马甲包渠道id
     */
    @NotNull
    private Integer channelId;
    /**
     * 展示模块 1：首页-精选爆款；5：找贷款；15：极速贷；
     */
    @NotNull
    private Byte showModule;
    //标签id
    private String[] labels;
    /**
     * 展示位置
     */
    private Byte showPosition;


}
