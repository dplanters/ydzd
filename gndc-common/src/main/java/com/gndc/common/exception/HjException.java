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
import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import javax.annotation.Nullable;
import java.net.URI;

@Getter
@Setter
public class HjException extends AbstractThrowableProblem implements ProblemMarker {

    private ResultCode result;

    private String template;

    public HjException(ResultCode result) {
        super(null, "HjException", Status.BAD_REQUEST, result.getI18NContent());
        this.result = result;
    }

    public HjException(ResultCode result, boolean isRecord) {
        this(null, "HjException", result.getI18NContent(), isRecord);
        this.result = result;
    }

    public HjException(ResultCode result, String template) {
        super(null, "HjException", Status.BAD_REQUEST, template);
        this.result = result;
        this.template = template;
    }

    public HjException(ResultCode result, String template, boolean isRecord) {
        this(null, "HjException", template, isRecord);
        this.result = result;
        this.template = template;
    }

    private HjException(@Nullable URI type, @Nullable String title, @Nullable String detail, boolean isRecord) {
        super(type, title, isRecord ? Status.INTERNAL_SERVER_ERROR : Status.BAD_REQUEST, detail);
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
