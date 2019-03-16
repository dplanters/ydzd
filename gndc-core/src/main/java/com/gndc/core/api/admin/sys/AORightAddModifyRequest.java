package com.gndc.core.api.admin.sys;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AORightAddModifyRequest extends RequestMessage {

    @Min(1)
    private Integer id;

    /**
     * 权限名
     */
    @NotNull
    @NotBlank
    private String rightName;

    /**
     * 权限URL
     */
    @NotNull
    @NotBlank
    private String rightUrl;

    /**
     * 权限路径
     */
    @NotNull
    @NotBlank
    private String rightPath;

    /**
     * 前端页面
     */
    @NotNull
    private String component;

    /**
     * 父权限id
     */
    @NotNull
    @NotBlank
    @Min(0)
    private String superId;

    /**
     * 平台
     */
    @NotNull
    @Min(1)
    private Byte platform;

    /**
     * 权限类型
     */
    @NotNull
    @Min(1)
    private Byte rightType;

    /**
     * 顺序
     */
    @NotNull
    @Min(1)
    private String rightOrder;

    /**
     * 图标
     */
    @NotNull
    @NotBlank
    private String rightPic;

    /**
     * 是否需要授权
     */
    @NotNull
    @Min(0)
    @Max(1)
    private Byte requireAuth;

    /**
     * 是否平级菜单
     */
    @NotNull
    @Min(0)
    @Max(1)
    private Boolean parallel;
}
