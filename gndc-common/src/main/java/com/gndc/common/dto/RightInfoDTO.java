package com.gndc.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class RightInfoDTO implements Serializable {
    private Integer id;

    private String rightName;

    private String rightUrl;

    private String rightPath;

    private String component;

    private Byte platform;

    private Integer superId;

    private Byte rightType;

    private Integer rightOrder;

    /**
     * 是否需要授权；1：需要；0：不需要
     */
    private Byte requireAuth;

    private String rightPic;

    private String uniqueSign;

    private Byte rightLevel;

    private Byte rightVisible;

    private String remark;

    private List<RightInfoDTO> children;

}