package com.gndc.core.model;

import com.gndc.common.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import tk.mybatis.mapper.annotation.LogicDelete;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Getter
@Setter
@Table(name = "dc_operation_banner")
public class Banner extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer productId;

    private String title;

    private Byte status;

    private Byte bannerStatus;

    private Byte position;

    private String link;

    private String imgUrl;

    private Date beginTime;

    private Date endTime;

}