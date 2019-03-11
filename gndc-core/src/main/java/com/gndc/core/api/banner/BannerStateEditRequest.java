/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.api.banner;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

/**
 * @author <a href="jiangxin8116@adpanshi.com">jiangxin8116</a>
 * @version V1.0.1
 * @Description banner更新
 * @date 2018年1月24日 下午2:39:16
 */
public class BannerStateEditRequest extends RequestMessage {

    private static final long serialVersionUID = 1L;

    private int bannerId;
    // banner状态 （1未上线/2上线/-1下线）
    private int status;
    // banner删除状态（1正常/-1删除）
    private int isDel;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.A_BANNER_STATE_EDIT);
    }

    /**
     * @return status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status 要设置的 status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    public int getBannerId() {
        return bannerId;
    }

    public void setBannerId(int bannerId) {
        this.bannerId = bannerId;
    }

    /**
     * @return isDel
     */
    public int getIsDel() {
        return isDel;
    }

    /**
     * @param isDel 要设置的 isDel
     */
    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }

}
