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

import java.util.List;
import java.util.Map;

/**
 * @author <a href="wangjie2355@adpanshi.com">wangjie</a>
 * @version V1.0.1
 * @Description
 * @date 2018年3月29日 上午11:06:13
 */
public class UserContactsRequest extends RequestMessage {
    /**
     * @Fields serialVersionUID:
     */
    private static final long serialVersionUID = 558605357014874485L;

    private List<Map<String, Object>> contacts; // 通讯录

    private int isOver;// 是否发送完成

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.C_AREA_CITY_BY_CHAR);
    }

    /**
     * @return contacts
     */
    public List<Map<String, Object>> getContacts() {
        return contacts;
    }

    /**
     * @param contacts 要设置的 contacts
     */
    public void setContacts(List<Map<String, Object>> contacts) {
        this.contacts = contacts;
    }

    /**
     * @return isOver
     */
    public int getIsOver() {
        return isOver;
    }

    /**
     * @param isOver 要设置的 isOver
     */
    public void setIsOver(int isOver) {
        this.isOver = isOver;
    }

}
