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
 * @Description 用户详细
 * @date 2018年3月7日 下午5:33:22
 */
public class UserInfoDetailRequest extends RequestMessage {

    /**
     * @Fields serialVersionUID:
     */
    private static final long serialVersionUID = 5924550455033489782L;

    /**
     * 用户ID
     */
    private int userId;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.A_USER_MANAGER_DETAIL);
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

}
