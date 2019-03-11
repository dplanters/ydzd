/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.api.user;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

/**
 * @author <a href="hugaoxiang8619@adpanshi.com">hugaoxiang</a>
 * @version V1.0.1
 * @Description
 * @date Sep 3, 2018 10:57:18 PM
 */
public class FacebookBindPhoneRequest extends RequestMessage {
    private static final long serialVersionUID = 1L;

    private String phone; // 手机号

    private String accountId;

    private String accessToken;

    private Integer userId;


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

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
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

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.P_FACEBOOK_PHONE_BIND);
    }
}
