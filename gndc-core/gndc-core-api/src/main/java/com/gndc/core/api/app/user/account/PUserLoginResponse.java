/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.api.app.user.account;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 用户登录响应
 */
@Getter
@Setter
public class PUserLoginResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 手机号
     */
    private String phone;

    /**
     * session
     */
    private String sessionId;

    /**
     * 是否有密码1：有；0：没有
     */
    private Integer hasPassword;

}
