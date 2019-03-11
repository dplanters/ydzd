/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.etc.product;

/**
 * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
 * @version V1.0.1
 * @Description
 * @date 2018年8月8日 下午3:41:55
 */
public class ProductClick {

    private byte eventType;

    private int count;

    private int productId;

    /**
     * @return eventType
     */
    public byte getEventType() {
        return eventType;
    }

    /**
     * @param eventType 要设置的 eventType
     */
    public void setEventType(byte eventType) {
        this.eventType = eventType;
    }

    /**
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count 要设置的 count
     */
    public void setCount(int count) {
        this.count = count;
    }

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

}
