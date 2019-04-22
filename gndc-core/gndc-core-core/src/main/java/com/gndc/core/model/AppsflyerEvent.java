package com.gndc.core.model;

import com.gndc.common.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Getter
@Setter
@Table(name = "dc_appsflyer_events")
public class AppsflyerEvent extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Byte eventType;

    private Date eventTime;

    private Date eventDate;

    private Integer mediaSource;

    private Integer useId;

    private Byte appType;

    private Integer productId;

}