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
 * @Description 广告详细
 * @date 2018年1月24日 下午2:39:16
 */
public class BannerDetailRequest extends RequestMessage {

    private static final long serialVersionUID = 1L;

    private int bannerId;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.A_BANNER_DETAIL);
    }

    public int getBannerId() {
        return bannerId;
    }

    public void setBannerId(int bannerId) {
        this.bannerId = bannerId;
    }

}
