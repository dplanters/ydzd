package com.gndc.common.model;

import com.gndc.common.model.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "dc_system_config")
public class SystemConfig extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 分组
     */
    private String group;

    /**
     * 配置项key
     */
    private String key;

    /**
     * 配置项value
     */
    private String value;

    /**
     * 备注，描述
     */
    private String remark;

    /**
     * 记录状态  1：正常；0：删除；
     */
    private Byte status;

    /**
     * 更新者id
     */
    @Column(name = "operator_id")
    private Integer operatorId;
}