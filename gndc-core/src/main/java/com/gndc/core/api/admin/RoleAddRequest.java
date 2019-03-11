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

import java.util.List;

/**
 * 角色新增，修改接口
 *
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description
 * @date 2018年1月24日 下午2:32:10
 */
public class RoleAddRequest extends RequestMessage {

    /**
     * @Fields serialVersionUID:
     */
    private static final long serialVersionUID = 1L;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 权限Ids
     */
    private List<Integer> rightIds;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Integer> getRightIds() {
        return rightIds;
    }

    public void setRightIds(List<Integer> rightIds) {
        this.rightIds = rightIds;
    }

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.A_ROLE_ADD);
    }
}
