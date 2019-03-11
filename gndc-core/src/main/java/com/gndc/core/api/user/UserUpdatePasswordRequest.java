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
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description 更改密码/设置密码
 * @date 2018年1月24日 下午2:40:15
 */
public class UserUpdatePasswordRequest extends RequestMessage {

    /**
     * @Fields serialVersionUID:
     */
    private static final long serialVersionUID = -370299782421019753L;

    /**
     * 原密码
     */
    private String password;
    /**
     * 新密码
     */
    private String newPassword;
    /**
     * 确认密码
     */
    private String confirmPassword;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.U_MODIFY_PWD);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}
