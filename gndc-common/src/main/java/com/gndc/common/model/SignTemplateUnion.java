package com.gndc.common.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "dc_sign_template_union")
public class SignTemplateUnion extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 签名id
     */
    private Integer signId;

    /**
     * 签名
     */
    private String signName;

    /**
     * 模板id
     */
    private Integer templateId;

    /**
     * 状态：1：正常；-1：删除
     */
    private Byte status;

}