/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.api.appsflyer;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

/**
 * @author <a href="litianwei8504@adpanshi.com">litianwei</a>
 * @version V1.0.1
 * @Description 渠道数据查询
 * @date 2018年8月9日 下午2:47:03
 */
public class ChannelDataRequest extends RequestMessage {
    /**
     * @Fields serialVersionUID:
     */
    private static final long serialVersionUID = -4610681578030934025L;

    /**
     * 渠道名称
     */
    private int mediaSource;

    /**
     * 查看时间类型 1：按日查看；2：按周查看；3：按月查看
     */
    private Integer timeType;

    /**
     * app类别
     */
    private Byte appType;

    private String timeBegin;

    private String timeEnd;

    private String timeWeek;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.CHANNEL_LIST);
    }

    public Byte getAppType() {
        return appType;
    }

    public void setAppType(Byte appType) {
        this.appType = appType;
    }

    public Integer getTimeType() {
        return timeType;
    }

    public void setTimeType(Integer timeType) {
        this.timeType = timeType;
    }

    public int getMediaSource() {
        return mediaSource;
    }

    public void setMediaSource(int mediaSource) {
        this.mediaSource = mediaSource;
    }

    public String getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(String timeBegin) {
        this.timeBegin = timeBegin;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getTimeWeek() {
        return timeWeek;
    }

    public void setTimeWeek(String timeWeek) {
        this.timeWeek = timeWeek;
    }
}
