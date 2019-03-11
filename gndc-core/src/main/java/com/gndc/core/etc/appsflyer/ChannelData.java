/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.etc.appsflyer;

import java.util.Date;

/**
 * @author <a href="litianwei8504@adpanshi.com">litianwei</a>
 * @version V1.0.1
 * @Description 渠道数据
 * @date 2018年8月9日 下午3:01:25
 */
public class ChannelData {

    // 日期
    private Date time;

    // 日期
    private Date timeEnd;

    // 日期
    private String strTime;

    // 日期
    private String strTimeEnd;

    // 渠道
    private Integer mediaSource;

    // 渠道名称
    private String mediaSourceName;

    // 安装数
    private int installCount;

    // 注册数
    private int registerCount;

    private Byte appType;

    private String appTypeName;

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getStrTimeEnd() {
        return strTimeEnd;
    }

    public void setStrTimeEnd(String strTimeEnd) {
        this.strTimeEnd = strTimeEnd;
    }

    public Byte getAppType() {
        return appType;
    }

    public void setAppType(Byte appType) {
        this.appType = appType;
    }

    public String getAppTypeName() {
        return appTypeName;
    }

    public void setAppTypeName(String appTypeName) {
        this.appTypeName = appTypeName;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getStrTime() {
        return strTime;
    }

    public void setStrTime(String strTime) {
        this.strTime = strTime;
    }

    public Integer getMediaSource() {
        return mediaSource;
    }

    public void setMediaSource(Integer mediaSource) {
        this.mediaSource = mediaSource;
    }

    public String getMediaSourceName() {
        return mediaSourceName;
    }

    public void setMediaSourceName(String mediaSourceName) {
        this.mediaSourceName = mediaSourceName;
    }

    public int getInstallCount() {
        return installCount;
    }

    public void setInstallCount(int installCount) {
        this.installCount = installCount;
    }

    public int getRegisterCount() {
        return registerCount;
    }

    public void setRegisterCount(int registerCount) {
        this.registerCount = registerCount;
    }

}
