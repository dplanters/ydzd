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
 * @author <a href="jiangxin8116@adpanshi.com">jiangxin8116</a>
 * @version V1.0.1
 * @Description 意见反馈
 * @date 2018年1月24日 下午2:39:16
 */
public class FeedBackRequest extends RequestMessage {

    private static final long serialVersionUID = 1L;

    // 内容
    private String content;
    // 联系方式
    private String phone;
    // 图片URL
    private String feedbackPictureUrl;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.U_FEEDBACK_ADD);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return feedbackPictureUrl
     */
    public String getFeedbackPictureUrl() {
        return feedbackPictureUrl;
    }

    /**
     * @param feedbackPictureUrl 要设置的 feedbackPictureUrl
     */
    public void setFeedbackPictureUrl(String feedbackPictureUrl) {
        this.feedbackPictureUrl = feedbackPictureUrl;
    }

}
