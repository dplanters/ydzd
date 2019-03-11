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
 * @Description 广告
 * @date 2018年1月24日 下午2:39:16
 */
public class BannerListRequest extends RequestMessage {

    private static final long serialVersionUID = 1L;

    // 广告状态
    private int status;

    private String onlineTimeBegin;

    private String onlineTimeEnd;

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

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.A_BANNER_LIST);
    }

    public String getOnlineTimeBegin() {
        return onlineTimeBegin;
    }

    public void setOnlineTimeBegin(String onlineTimeBegin) {
        this.onlineTimeBegin = onlineTimeBegin;
    }

    public String getOnlineTimeEnd() {
        return onlineTimeEnd;
    }

    public void setOnlineTimeEnd(String onlineTimeEnd) {
        this.onlineTimeEnd = onlineTimeEnd;
    }

}
