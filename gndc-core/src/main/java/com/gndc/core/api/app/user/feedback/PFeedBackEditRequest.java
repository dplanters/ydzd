/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.api.app.user.feedback;


import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

/**
 * 客户端意见反馈请求
 */
@Getter
@Setter
public class PFeedBackEditRequest extends RequestMessage {

    private static final long serialVersionUID = 1L;

    // 内容
    private String content;
    // 联系方式
    private String phone;
    // 图片URL
    private String feedbackPictureUrl;

}