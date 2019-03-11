/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.etc.user;

import com.gndc.common.utils.DateUtil;
import com.gndc.core.model.UserCollection;

/**
 * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
 * @version V1.0.1
 * @Description
 * @date 2018年8月20日 上午9:18:16
 */
public class UserCollectionExt extends UserCollection {

    /**
     * 产品名称
     */
    private String productName;

    private byte isDel;

    /**
     * @return isDel
     */
    public byte getIsDel() {
        return isDel;
    }

    /**
     * @param isDel 要设置的 isDel
     */
    public void setIsDel(byte isDel) {
        this.isDel = isDel;
    }

    /**
     * @return productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName 要设置的 productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStrCreateTime() {
        return DateUtil.timeToString(getCreateTime(), DateUtil.FORMAT_2);
    }

}
