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
 * 列表查询
 *
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description
 * @date 2018年1月24日 下午2:31:11
 */
public class AdminListRequest extends RequestMessage {

    /**
     * @Fields serialVersionUID:
     */
    private static final long serialVersionUID = 1L;

    private String loginName;

    private String name;

    private String phone;

    private String roleId;

    private String addTimeBegin;

    private String addTimeEnd;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.A_ADMIN_PAGE_LIST);
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getAddTimeBegin() {
        return addTimeBegin;
    }

    public void setAddTimeBegin(String addTimeBegin) {
        this.addTimeBegin = addTimeBegin;
    }

    public String getAddTimeEnd() {
        return addTimeEnd;
    }

    public void setAddTimeEnd(String addTimeEnd) {
        this.addTimeEnd = addTimeEnd;
    }
}
