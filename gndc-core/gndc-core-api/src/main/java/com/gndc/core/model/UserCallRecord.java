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
@Table(name = "dc_call_record")
public class UserCallRecord extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userPhone;

    private Integer userId;

    private String userName;

    private Integer serviceId;

    private String serviceName;

    private String question;

    private String answer;

    private Byte isSolve;

    private String remark;

}