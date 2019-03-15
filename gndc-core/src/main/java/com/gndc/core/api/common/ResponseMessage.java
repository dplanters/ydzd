/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.api.common;

import com.github.pagehelper.PageInfo;
import com.gndc.common.enums.ResultCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ResponseMessage<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 返回成功或失败
     */
    private Boolean success = true;

    /**
     * 响应码,0为成功
     */
    private Integer code = 0;
    /**
     * 提交或返回数据
     */
    private T data;

    private String msg = "请求成功";

    private PageInfo page;

    public void createError(ResultCode result) {
        this.success = false;
        this.code = result.getCode();
        this.msg = result.getI18NContent();
    }

}