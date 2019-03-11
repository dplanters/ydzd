/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.api.admin;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

/**
 * 修改成员
 *
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description
 * @date 2018年1月24日 下午2:30:59
 */
public class AdminEditRequest extends RequestMessage {

    /**
     * @Fields serialVersionUID:
     */
    private static final long serialVersionUID = 1L;

    private int id;
    /**
     * 成员姓名
     */
    private String name;
    /**
     * 角色id
     */
    private int roleId;
    /**
     * 登录名
     */
    private String loginName;

    /**
     * 手机号
     */
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 要设置的 name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return loginName
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * @param loginName 要设置的 loginName
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone 要设置的 phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.A_ADMIN_EDIT);
    }
}
