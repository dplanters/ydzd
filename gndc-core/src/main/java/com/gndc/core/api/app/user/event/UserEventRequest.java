/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.api.app.user.event;


import com.gndc.common.api.RequestMessage;

/**
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description 获取用户信息
 * @date 2018年1月24日 下午2:39:16
 */
public class UserEventRequest extends RequestMessage {

    private static final long serialVersionUID = 1L;

    /**
     * 事件类型 1热推点击；2列表点击；3点击下载；4收藏；5取消收藏；6用户打开app
     */
    private byte type;

    private int productId;

    /**
     * @return type
     */
    public byte getType() {
        return type;
    }

    /**
     * @param type 要设置的 type
     */
    public void setType(byte type) {
        this.type = type;
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

    @Override
    public void createHeader() {
        super.createHeader();
    }

}
