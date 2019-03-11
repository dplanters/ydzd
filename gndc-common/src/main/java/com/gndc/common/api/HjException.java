/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.api;

/**
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description 异常类封装
 * @date 2018年1月25日 上午9:48:18
 */
public class HjException extends Exception {

    private static final long serialVersionUID = 1L;

    private int errorCode = ResultCode.EXCEPTION.getCode();

    private Object msgExt;

    public HjException(String message) {
        super(message);
    }

    public HjException(ResultCode result) {
        super(result.getI18NContent());
        this.errorCode = result.getCode();
    }

    public HjException(ResultCode result, Object msgExt) {
        super(result.getI18NContent());
        this.errorCode = result.getCode();
        this.msgExt = msgExt;
    }

    public HjException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public HjException(String errorCode, String message) {
        super(message);
        this.errorCode = Integer.parseInt(errorCode);
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Object getMsgExt() {
        return msgExt;
    }

    public void setMsgExt(Object msgExt) {
        this.msgExt = msgExt;
    }

}
