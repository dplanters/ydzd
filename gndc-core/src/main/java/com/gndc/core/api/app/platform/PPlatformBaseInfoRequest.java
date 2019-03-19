package com.gndc.core.api.app.platform;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 平台基本信息获取请求
 */
@Getter
@Setter
public class PPlatformBaseInfoRequest extends RequestMessage {


    /**
     * 信息类型
     */
    @NotNull
    @NotBlank
    private String infoType;
}
