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
@Table(name = "dc_product_statistic")
public class ProductStatistic extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer prodId;

    private String productName;

    private Integer hotClicks;

    private Integer listClicks;

    private Integer clickDownloads;

    private Integer actualDownloads;

    private Integer actualInstalls;

    private Date statisticDate;

}