/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.api.product;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author <a href="hugaoxiang8619@adpanshi.com">hugaoxiang</a>
 * @version V1.0.1
 * @Description
 * @date Aug 23, 2018 2:38:11 PM
 */
public class ProductDetailRequest extends RequestMessage {
    private static final long serialVersionUID = 1L;
    private boolean isHotProduct;
    @NotNull
    @Min(1)
    private Integer productId;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.C_PRODUCT_DETAIL);
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public boolean getIsHotProduct() {
        return isHotProduct;
    }

    public void setIsHotProduct(boolean isHotProduct) {
        this.isHotProduct = isHotProduct;
    }

}
