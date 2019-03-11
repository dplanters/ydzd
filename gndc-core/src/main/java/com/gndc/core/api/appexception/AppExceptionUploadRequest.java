/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.api.appexception;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

/**
 * app端异常上报接口
 *
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description
 * @date 2018年7月30日 下午2:58:09
 */
public class AppExceptionUploadRequest extends RequestMessage {

    /**
     * @Fields serialVersionUID:
     */
    private static final long serialVersionUID = 12L;
    private int userId;
    private String sessionId;
    private String deviceAndVersionInfo;
    private String exception;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.APPEXCEPTION_UPLOAD);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getDeviceAndVersionInfo() {
        return deviceAndVersionInfo;
    }

    public void setDeviceAndVersionInfo(String deviceAndVersionInfo) {
        this.deviceAndVersionInfo = deviceAndVersionInfo;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

}
