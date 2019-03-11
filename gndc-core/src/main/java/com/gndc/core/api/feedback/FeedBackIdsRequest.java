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

import java.util.List;

/**
 * @author <a href="jiangxin8116@adpanshi.com">jiangxin</a>
 * @version V1.0.1
 * @Description 批量处理反馈意见ID
 * @date 2018年3月8日 上午8:56:18
 */
public class FeedBackIdsRequest extends RequestMessage {

    private static final long serialVersionUID = 1L;

    // 意见反馈id
    private List<Integer> ids;

    // 修改的状态值，4:已处理
    private byte status;

    // 备注
    private String replyContent;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.A_FEEDBACK_RE);
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
}
