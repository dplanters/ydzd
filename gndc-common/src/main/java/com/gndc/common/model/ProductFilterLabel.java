package com.gndc.common.model;

import com.gndc.common.model.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "dc_product_filter_label")
public class ProductFilterLabel extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "product_id")
    private Integer productId;
    /**
     * 与system_config表对应
     */
    @Column(name = "label_id")
    private Integer labelId;
    /**
     * 更新者id
     */
    @Column(name = "operator_id")
    private Integer operatorId;
}