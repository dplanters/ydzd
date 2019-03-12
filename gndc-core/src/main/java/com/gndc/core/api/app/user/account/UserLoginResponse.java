/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.api.app.user.account;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

/**
 * 用户登录
 *
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description
 * @date 2018年1月24日 下午2:37:52
 */
public class UserLoginResponse extends RequestMessage {

    private static final long serialVersionUID = 1L;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.P_SMS_LOGIN);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getValCode() {
        return valCode;
    }

    public void setValCode(String valCode) {
        this.valCode = valCode;
    }

    public String getTermType() {
        return termType;
    }

    public void setTermType(String termType) {
        this.termType = termType;
    }

    public String getRegChannel() {
        return regChannel;
    }

    public void setRegChannel(String regChannel) {
        this.regChannel = regChannel;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppPackage() {
        return appPackage;
    }

    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
    }

}
