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
@Table(name = "dc_appsflyer_click")
public class AppFlayerClick extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    private Integer productId;

    private Date createTime;

    private Date updateTime;

    private Byte status;

    private Byte type;

}