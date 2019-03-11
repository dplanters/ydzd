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
import lombok.Getter;
import lombok.Setter;

/**
 * 添加成员
 *
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description
 * @date 2018年1月24日 下午2:30:06
 */
@Getter
@Setter
public class AdminAddRequest extends RequestMessage {

    /**
     * @Fields serialVersionUID:
     */
    private static final long serialVersionUID = 1L;

    /**
     * 工号
     */
    private int operId;
    /**
     * 成员姓名，真实姓名
     */
    private String name;

    private String partnerName;
    /**
     * 角色名 id
     */
    private int roleId;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 登录名
     */
    private String loginName;

    private String password;

    private int level;

    private int partnerId;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.A_ADMIN_ADD);
    }
}
