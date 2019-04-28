package com.gndc.core.model;

import com.gndc.common.model.BaseEntity;
import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "dc_partner_api")
@Entity
public class PartnerApi extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 机构id
     */
    @Column(name = "partner_id")
    private Integer partnerId;

    /**
     * 接口地址
     */
    @Column(name = "api_url")
    private String apiUrl;

    /**
     * 接口类型
     */
    @Column(name = "api_type")
    private Byte apiType;
    /**
     * 状态  1：正常；0：删除
     */
    private Byte status;
}