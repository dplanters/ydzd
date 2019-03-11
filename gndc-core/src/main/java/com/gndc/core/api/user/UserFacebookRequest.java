package com.gndc.core.api.user;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

public class UserFacebookRequest extends RequestMessage {

    private static final long serialVersionUID = 1L;

    private String facebookId;

    private String facebookUser;

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

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.P_OAUTH_LOGIN);
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


    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getFacebookUser() {
        return facebookUser;
    }

    public void setFacebookUser(String facebookUser) {
        this.facebookUser = facebookUser;
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

}
