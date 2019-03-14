package com.gndc.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gndc.common.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import tk.mybatis.mapper.annotation.LogicDelete;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Table(name = "dc_right")
public class Right extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @LogicDelete(notDeletedValue = 1, isDeletedValue = -1)
    private Byte rightStatus;

    private String rightName;

    private String rightUrl;

    private String rightPath;

    private String component;

    private Byte platform;

    private Integer supperId;

    private Byte rightType;

    private Integer rightOrder;

    private String rightPic;

    private String uniqueSign;

    private Byte rightLevel;

    @Transient
    private List<Right> rights;

}