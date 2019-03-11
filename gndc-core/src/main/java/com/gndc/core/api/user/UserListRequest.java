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
 * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
 * @version V1.0.1
 * @Description
 * @date 2018年8月8日 上午10:15:23
 */
public class UserListRequest extends RequestMessage {
    /**
     * @Fields serialVersionUID:
     */
    private static final long serialVersionUID = 5924550455033489782L;

    /**
     * 用户ID
     */
    private int userId;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 注册开始时间
     */
    private String regDateBegin;

    /**
     * 注册结束时间
     */
    private String regDateEnd;

    /**
     * 来源渠道
     */
    private String regChannel;

    /**
     * 信息认证
     */
    private int isAuth;

    /**
     * 职业
     */
    private int job;

    /**
     * 认证开始时间
     */
    private String authDateBegin;

    /**
     * 认证结束时间
     */
    private String authDateEnd;

    /**
     * 状态 -1未绑定手机号；1未填完资料;2已填写资料
     */
    private byte status;

    /**
     * app名
     */
    private String appName;

    /**
     * @return appName
     */
    public String getAppName() {
        return appName;
    }

    /**
     * @param appName 要设置的 appName
     */
    public void setAppName(String appName) {
        this.appName = appName;
    }

    /**
     * @return status
     */
    public byte getStatus() {
        return status;
    }

    /**
     * @param status 要设置的 status
     */
    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.A_USER_MANAGER_LIST);
    }

    /**
     * @return userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId 要设置的 userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegDateBegin() {
        return regDateBegin;
    }

    public void setRegDateBegin(String regDateBegin) {
        this.regDateBegin = regDateBegin;
    }

    public String getRegDateEnd() {
        return regDateEnd;
    }

    public void setRegDateEnd(String regDateEnd) {
        this.regDateEnd = regDateEnd;
    }

    /**
     * @return regChannel
     */
    public String getRegChannel() {
        return regChannel;
    }

    /**
     * @param regChannel 要设置的 regChannel
     */
    public void setRegChannel(String regChannel) {
        this.regChannel = regChannel;
    }

    public int getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(int isAuth) {
        this.isAuth = isAuth;
    }

    public int getJob() {
        return job;
    }

    public void setJob(int job) {
        this.job = job;
    }

    public String getAuthDateBegin() {
        return authDateBegin;
    }

    public void setAuthDateBegin(String authDateBegin) {
        this.authDateBegin = authDateBegin;
    }

    public String getAuthDateEnd() {
        return authDateEnd;
    }

    public void setAuthDateEnd(String authDateEnd) {
        this.authDateEnd = authDateEnd;
    }

}
