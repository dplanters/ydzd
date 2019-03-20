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
public class HjException extends RuntimeException implements ProblemMarker {

    private ResultCode result;

    private String template;

    public HjException(ResultCode result) {
        super(result.getI18NContent());
        this.result = result;
    }

    public HjException(ResultCode result, String template) {
        this.result = result;
        this.template = template;
    }

    @Override
    public Integer getCode() {
        return result.getCode();
    }

    @Override
    public String getMsg() {
        return null == template ? result.getI18NContent() : template;
    }

}
