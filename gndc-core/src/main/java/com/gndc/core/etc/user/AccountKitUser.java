/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.etc.user;

/**
 * @author <a href="hugaoxiang8619@adpanshi.com">hugaoxiang</a>
 * @version V1.0.1
 * @Description
 * @date Aug 30, 2018 4:12:22 PM
 */
public class AccountKitUser {
    private String id;
    private AccountKitPhone phone;
    private AccountKitApplication application;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AccountKitPhone getPhone() {
        return phone;
    }

    public void setPhone(AccountKitPhone phone) {
        this.phone = phone;
    }

    public AccountKitApplication getApplication() {
        return application;
    }

    public void setApplication(AccountKitApplication application) {
        this.application = application;
    }
}
