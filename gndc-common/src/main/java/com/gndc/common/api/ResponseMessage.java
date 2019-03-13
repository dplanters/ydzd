/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.api;

import com.github.pagehelper.PageInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @param <T>
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description 响应基类封装
 * @date 2018年1月25日 上午9:50:04
 */
@Getter
@Setter
public class ResponseMessage<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    protected Header header;

    /**
     * 返回成功或失败
     */
    private Boolean success = true;

    /**
     * 提交或返回数据
     */
    private T data;

    private String msg = "请求成功";

    private PageInfo page;

    public ResponseMessage() {

    }

    public ResponseMessage(RequestMessage request) {

    }

    public void createError(Header header) {
        this.header.setCode(header.getCode());
        this.header.setMsg(header.getMsg());
    }

    public void createError(ResultCode result) {
        this.header.setCode(result.getCode());
        this.header.setMsg(result.getI18NContent());
    }

    public void createError(HjException e) {
        this.header.setCode(e.getErrorCode());
        this.header.setMsg(e.getMessage());
        this.header.setMsgExt(e.getMsgExt());
    }
}
