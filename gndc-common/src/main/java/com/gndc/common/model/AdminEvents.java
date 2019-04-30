package com.gndc.common.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Table(name = "dc_admin_events")
public class AdminEvents extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer adminId;

    private Integer roleId;

    private Integer eventType;

    private Date eventTime;

    private String ipAddress;

    private String remark;

}