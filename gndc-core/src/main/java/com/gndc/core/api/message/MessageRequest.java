/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.api.message;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

/**
 * @author <a href="wangjie2355@adpanshi.com">wangjie</a>
 * @version V1.0.1
 * @Description
 * @date 2018年3月19日 下午5:08:32
 */
public class MessageRequest extends RequestMessage {

    private static final long serialVersionUID = 1L;

    private int messageId;

    /**
     * @return messageId
     */
    public int getMessageId() {
        return messageId;
    }

    /**
     * @param messageId 要设置的 messageId
     */
    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.U_MESSAGE_LIST);
    }

}
