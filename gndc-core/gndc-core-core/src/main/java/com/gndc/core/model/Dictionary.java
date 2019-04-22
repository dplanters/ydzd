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
@Table(name = "dc_dict")
public class Dictionary extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String optionGroup;

    private String optionValue;

    private String optionName;

    private String optionNameCn;

    private String supperValue;

    private Byte status;

    private String remark;

    private String remarkCn;
}