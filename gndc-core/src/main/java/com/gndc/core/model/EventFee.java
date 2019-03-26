package com.gndc.core.model;

import com.gndc.common.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
@Getter
@Setter
@Table(name = "dc_event_fee")
public class EventFee extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 事件ID
     */
    private Integer eventId;

    /**
     * 产品id
     */
    private Integer productId;

    /**
     * 合作机构ID
     */
    private Integer partnerId;

    /**
     * 费用金额
     */
    private BigDecimal fee;

    /**
     * 费用分类：1-h5 2-Api
     */
    private Byte feeType;

    /**
     * 合作模式 1:CPI;2:CPA;3:CPL;4:CPS;5:CPC
     */
    private Byte coopeMode;

    /**
     * 事件类型 1热推点击；2列表点击；3点击下载；4收藏；5取消收藏；6打开app;7 登录;8产品点击
     */
    private Byte eventType;

    /**
     * 费用状态 0-未结算 1-已结算
     */
    private Byte feeStatus;

    /**
     * 是否删除  1正常;-1删除
     */
    private Byte status;
}