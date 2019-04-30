/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.admin.api.app.user.feedback;


import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 客户端意见反馈请求
 */
@Getter
@Setter
public class PFeedBackEditRequest extends RequestMessage {

    private static final long serialVersionUID = 1L;

    // 内容
    @NotNull
    @NotBlank
    private String content;
    // 联系方式
    @NotNull
    @NotBlank
    private String phone;
    // 图片URL
    @NotNull
    @NotBlank
    private String feedbackPictureUrl;

}
