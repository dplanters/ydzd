/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.api.feedback;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

/**
 * @author <a href="jiangxin8116@adpanshi.com">jiangxin</a>
 * @version V1.0.1
 * @Description 意见反馈列表
 * @date 2018年3月7日 下午7:50:30
 */
public class FeedBackListRequest extends RequestMessage {

    private static final long serialVersionUID = 1L;
    // 注册手机号
    private String phone;
    // 用户ID
    private int userId;
    // 提交时间
    private String subTimeBegin;

    private String subTimeEnd;
    // 状态
    private int status;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.A_FEEDBACK_LIST);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSubTimeBegin() {
        return subTimeBegin;
    }

    public void setSubTimeBegin(String subTimeBegin) {
        this.subTimeBegin = subTimeBegin;
    }

    public String getSubTimeEnd() {
        return subTimeEnd;
    }

    public void setSubTimeEnd(String subTimeEnd) {
        this.subTimeEnd = subTimeEnd;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
