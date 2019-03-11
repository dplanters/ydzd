/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.api.advertis;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

/**
 * @author <a href="litianwei8504@adpanshi.com">litianwei8504</a>
 * @version V1.0.1
 * @Description 广告
 * @date 2018年1月24日 下午2:39:16
 */
public class AdvertisListRequest extends RequestMessage {

    private static final long serialVersionUID = 1L;

    // 广告状态
    private int status;

    private int type;

    private String timeBegin;

    private String timeEnd;

    /**
     * @return status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status 要设置的 status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type 要设置的 type
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return timeBegin
     */
    public String getTimeBegin() {
        return timeBegin;
    }

    /**
     * @param timeBegin 要设置的 timeBegin
     */
    public void setTimeBegin(String timeBegin) {
        this.timeBegin = timeBegin;
    }

    /**
     * @return timeEnd
     */
    public String getTimeEnd() {
        return timeEnd;
    }

    /**
     * @param timeEnd 要设置的 timeEnd
     */
    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.ADVERTIS_LIST);
    }

}
