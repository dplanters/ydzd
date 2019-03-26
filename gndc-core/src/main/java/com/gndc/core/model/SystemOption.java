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
@Table(name = "dc_system_option")
public class SystemOption extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String optionGroup;

    private String optionKey;

    private String optionValue;

    private String remark;

}