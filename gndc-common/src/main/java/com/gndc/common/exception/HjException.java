/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.exception;


import com.gndc.common.enums.ResultCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HjException extends RuntimeException {

    private ResultCode result;

    private Integer code;

    private String msg;

    public HjException(ResultCode result) {
        super(result.getMsg());
        this.result = result;
    }

    public HjException(ResultCode result, String msg) {
        super(result.getMsg());
        this.result = result;
        this.msg = msg;
    }

    public Integer getCode() {
        return result.getCode();
    }

    public String getMsg() {
        return null == msg ? result.getMsg() : msg;
    }

}
