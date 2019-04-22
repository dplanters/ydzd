package com.gndc.core.model;

import com.gndc.common.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.LogicDelete;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "dc_product")
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 合作机构ID
     */
    private Integer partnerId;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 合作模式 1:CPI;2:CPA;3:CPL;4:CPS;5:CPC
     */
    private Byte coopeMode;

    /**
     * logo url
     */
    private String logoUrl;

    /**
     * 一句话描述产品
     */
    private String description;

    /**
     * 客服电话
     */
    private String custServPhone;

    /**
     * 申请条件
     */
    private String applyCondition;

    /**
     * 申请流程
     */
    private String applyProcess;

    /**
     * 还款说明
     */
    private String repayInfo;

    /**
     * 位置
     */
    private Byte position;

    /**
     * 最新上线时间
     */
    private Date onlineTime;

    /**
     * 最后下线时间
     */
    private Date offlineTime;

    /**
     * 排序方式 1不固定排序；-1固定排序
     */
    private Byte sortType;

    /**
     * 固定排序位置
     */
    private Integer fixedSortType;

    /**
     * 状态  1未上线;2上线;-1下线
     */
    private Byte productStatus;

    /**
     * 状态  1存在；0删除
     */
    private Byte status;

    /**
     * 产品Android手机跳转地址
     */
    private String androidLink;

    /**
     * 产品iOS手机跳转地址
     */
    private String iosLink;

    /**
     * 借贷金额开始
     */
    private BigDecimal borrowAmountBegin;

    /**
     * 借贷金额结束
     */
    private BigDecimal borrowAmountEnd;

    /**
     * 是否展示详情
     */
    private Byte isDetail;

    /**
     * 日利率
     */
    private BigDecimal dayRate;

    /**
     * 合作价格
     */
    private BigDecimal coopePrice;

    /**
     * 标签1:审批快，多个";"隔开
     */
    private String tags;

}