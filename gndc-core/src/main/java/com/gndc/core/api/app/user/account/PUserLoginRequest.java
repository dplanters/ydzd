/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.api.app.user.account;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PUserLoginRequest extends RequestMessage {

    /**
     * 手机号
     */
    private String phone;

    /**
     * 验证码登录
     */
    private String valCode;

    /**
     * 密码登录
     */
    private String password;
    /**
     * 设备token
     */
    private String imei;
    /**
     * 终端类型
     */
    private String termType;
    /**
     * 推广渠道
     */
    private String regChannel;
    /**
     * APP名
     */
    private String appName;
    /**
     * APP包名
     */
    private String appPackage;

}