package com.gndc.core.model;

import com.gndc.common.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "dc_right")
public class Right extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Byte rightStatus;

    private String rightName;

    private String rightUrl;

    private String rightPth;

    private String component;

    private Byte platform;

    private Integer supperId;

    private Byte rightType;

    private Integer rightOrder;

    private String rightPic;

    private String uniqueSign;

    private Byte rightLevel;

}