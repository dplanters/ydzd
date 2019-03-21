/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.api.admin.user;


import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AOUserListRequest extends RequestMessage {


    private static final long serialVersionUID = -8726281134082428052L;
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
}
