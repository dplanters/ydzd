/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.api.appsflyer;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

/**
 * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
 * @version V1.0.1
 * @Description
 * @date 2018年9月5日 上午10:32:11
 */
public class AppsflyerClickRequest extends RequestMessage {
    /**
     * @Fields serialVersionUID:
     */
    private static final long serialVersionUID = -4610681578030934025L;

    private int productId;

    /**
     * @return productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     * @param productId 要设置的 productId
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.APPSFLYER_CLICK);
    }
}
