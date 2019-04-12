/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.api.app.platform;


import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class PAppExceptionUploadRequest extends RequestMessage {


    private static final long serialVersionUID = 97305921490193284L;

    /**
     * 设备类型及app版本号
     */
    @NotBlank
    private String deviceAndVersionInfo;

    /**
     * 异常信息描述
     */
    @NotBlank
    private String exception;

}
