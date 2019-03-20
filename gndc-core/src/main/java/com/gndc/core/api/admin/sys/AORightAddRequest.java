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
public class AORightAddRequest extends RequestMessage {

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
    private String rightPath;

    /**
     * 前端页面
     */
    @NotBlank
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
    @Min(1)
    private String rightOrder;

    /**
     * 权限层级
     */
    @NotNull
    @Min(1)
    private Byte rightLevel;

    /**
     * 图标
     */
    private String rightPic;

    /**
     * 是否需要授权
     */
    @NotNull
    @Min(0)
    @Max(1)
    private Byte requireAuth;

    /**
     *权限是否可见
     */
    @NotNull
    @Min(0)
    @Max(1)
    private Byte rightVisible;

    /**
     * 备注
     */
    private String remark;
}