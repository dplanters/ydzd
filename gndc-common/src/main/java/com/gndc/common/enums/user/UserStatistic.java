/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.enums.user;

/**
 * @author <a href="jiangixn8116@adpanshi.com">jiangixn8116</a>
 * @version V1.0.1
 * @Description 菲律宾版用户认证
 * @date 2018年1月24日 下午4:53:29
 */
public enum UserStatistic {

    TODAY_NEW_USER((byte) 1, "TODAY_NEW_USER"), // 今日注册

    TODAY_ACTIVE_USER((byte) 2, "TODAY_ACTIVE_USER"), // 今日活跃

    TODAY_LOST_USER((byte) 3, "TODAY_LOST_USER"), // 今日流失

    TODAY_NEW_DOWNLOADS((byte) 4, "TODAY_NEW_DOWNLOADS"), // 今日下载

    TODAY_NEW_INSTALL((byte) 5, "TODAY_NEW_INSTALL"), // 今日安装

    HISTORY_USER((byte) 6, "HISTORY_USER"), // 历史注册

    HISTORY_DOWNLOADS((byte) 7, "HISTORY_DOWNLOADS"), // 历史下载

    HISTORY_INSTALL((byte) 8, "HISTORY_INSTALL"); // 历史安装

    private byte code;
    private String name;

    UserStatistic(byte code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getName(byte code) {
        for (UserStatistic userSexType : UserStatistic.values()) {
            if (userSexType.code == code) {
                return userSexType.name;
            }
        }
        return null;
    }

    public byte getCode() {
        return code;
    }

    public void setCode(byte code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
