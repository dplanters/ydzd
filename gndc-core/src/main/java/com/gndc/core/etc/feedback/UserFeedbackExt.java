/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.etc.feedback;

import com.gndc.common.utils.DateUtil;
import com.gndc.core.model.UserFeedback;

/**
 * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
 * @version V1.0.1
 * @Description
 * @date 2018年8月20日 下午2:17:01
 */
public class UserFeedbackExt extends UserFeedback {
    private String adminName;

    public String getStrCreateTime() {
        return DateUtil.timeToString(getCreateTime(), DateUtil.FORMAT_2);
    }

    public String getStrReplyTime() {
        return DateUtil.timeToString(getReplyTime(), DateUtil.FORMAT_2);
    }

    /**
     * @return adminName
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * @param adminName 要设置的 adminName
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

}
