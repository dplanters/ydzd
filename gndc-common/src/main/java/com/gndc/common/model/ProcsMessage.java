/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.model;

import java.io.Serializable;

/**
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description 存储过程执行返回结果
 * @date 2018年1月24日 下午4:55:29
 */
public class ProcsMessage implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -6746483322310995904L;
    /**
     * 结果码 0-正常执行 1-过程中有异常
     */
    private String erroCode;
    /**
     * 返回信息
     */
    private String errorMessage;

    public String geterroCode() {
        return erroCode;
    }

    public void seterroCode(String erroCode) {
        this.erroCode = erroCode;
    }

    public String geterrorMessage() {
        return errorMessage;
    }

    public void seterrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
