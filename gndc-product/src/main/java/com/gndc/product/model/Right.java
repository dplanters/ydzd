package com.gndc.product.model;

import com.gndc.common.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Table(name = "dc_right")
public class Right extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Transient
    private List<Right> children;

}