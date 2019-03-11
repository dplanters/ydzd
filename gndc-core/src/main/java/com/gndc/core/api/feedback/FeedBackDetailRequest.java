/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.api.feedback;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

/**
 * @author <a href="jiangxin8116@adpanshi.com">jiangxin</a>
 * @version V1.0.1
 * @Description 意见反馈详情
 * @date 2018年3月8日 上午8:56:18
 */
public class FeedBackDetailRequest extends RequestMessage {

    private static final long serialVersionUID = 1L;

    // 意见反馈
    private int id;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.A_FEEDBACK_DETAIL);
    }

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id 要设置的 id
     */
    public void setId(int id) {
        this.id = id;
    }

}
