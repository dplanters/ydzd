package com.gndc.common.api.admin.product.productincomingconfig;

import com.gndc.common.api.RequestMessage;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class AOProductIncomingConfigAddRequest extends RequestMessage {

    /**
     * 产品id
     */
    private Integer productId;
    /**
     * 新客
     */
    private Integer newUser;
    /**
     * 新客是否限制 1：限制；0：不限制；
     */
    private Byte newUserLimit;
    /**
     * 老客
     */
    private Integer oldUser;
    /**
     * 老客是否限制 1：限制；0：不限制；
     */
    private Byte oldUserLimit;
    /**
     * 按照UV
     */
    private Integer uv;
    /**
     * 按照UV是否限制 1：限制；0：不限制；
     */
    private Byte uvLimit;
    /**
     * 按照CPA
     */
    private Integer cpa;
    /**
     * 按照CPA是否限制 1：限制；0：不限制；
     */
    private Byte cpaLimit;
    /**
     * 按照CPS
     */
    private Integer cps;
    /**
     * 按照CPS是否限制 1：限制；0：不限制；
     */
    private Byte cpsLimit;
    /**
     * 生效时间
     */
    private Date effectTime;
    /**
     * 更新者id
     */
    @Column(name = "operator_id")
    private Integer operatorId;
}