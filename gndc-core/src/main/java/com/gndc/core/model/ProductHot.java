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
@Table(name = "dc_product_hot")
public class ProductHot extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer productId;

    private String productName;

    private Byte hotStatus;

    private Byte position;

    private Date onlineTime;

    private Date offlineTime;

}