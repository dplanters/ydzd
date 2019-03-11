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
 * @author <a href="jiangxin8116@adpanshi.com">jiangxin</a>
 * @version V1.0.1
 * @Description 后台管理--用户管理 -查询列表
 * @date 2018年3月7日 下午2:24:40
 */
public class UserInfoListRequest extends RequestMessage {

    /**
     * @Fields serialVersionUID:
     */
    private static final long serialVersionUID = 5924550455033489782L;

    /**
     * 用户ID
     */
    private String userId;

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
    private int isFrom;

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

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.A_USER_MANAGER_LIST);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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

    public int getIsFrom() {
        return isFrom;
    }

    public void setIsFrom(int isFrom) {
        this.isFrom = isFrom;
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
