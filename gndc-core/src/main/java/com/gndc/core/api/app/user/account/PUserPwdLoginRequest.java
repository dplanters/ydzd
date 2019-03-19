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

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class PUserPwdLoginRequest extends RequestMessage {

    /**
     * 手机号
     */
    @NotNull
    @NotBlank
    @Pattern(regexp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$")
    private String phone;

    /**
     * 密码登录
     */
    @NotNull
    @NotBlank
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
