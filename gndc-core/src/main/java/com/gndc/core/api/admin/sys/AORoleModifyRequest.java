/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.api.admin.sys;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class AORoleModifyRequest extends RequestMessage {

    @NotNull
    @Min(1)
    private Integer id;

    @NotNull
    @Min(1)
    private Byte platform;

    /**
     * 角色名
     */
    @NotNull
    @NotBlank
    private String roleName;

    /**
     * 权限Ids
     */
    @NotNull
    @NotEmpty
    private List<Integer> rightIds;

}
