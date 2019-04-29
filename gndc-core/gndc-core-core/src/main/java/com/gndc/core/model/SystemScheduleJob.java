package com.gndc.core.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "dc_system_schedule_job")
@Getter
@Setter
public class SystemScheduleJob implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 任务名
     */
    @Column(name = "job_name")
    private String jobName;

    /**
     * 任务执行时调用哪个类的方法 包名+类名
     */
    @Column(name = "bean_class")
    private String beanClass;

    /**
     * cron表达式
     */
    @Column(name = "cron_expression")
    private String cronExpression;

    /**
     * 任务调用的方法名
     */
    @Column(name = "method_name")
    private String methodName;

    /**
     * 是否同步1：同步0：不同步
     */
    @Column(name = "is_concurrent")
    private Byte isConcurrent;

    /**
     * 任务描述
     */
    private String description;

    /**
     * 任务状态1：开始0：停止
     */
    @Column(name = "job_status")
    private Byte jobStatus;

    /**
     * 任务分组
     */
    @Column(name = "job_group")
    private String jobGroup;

    /**
     * 拓展条件id
     */
    @Column(name = "extend_id")
    private Integer extendId;

    /**
     * 记录状态  1：正常；0：删除；
     */
    private Byte status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新者id
     */
    @Column(name = "operator_id")
    private Integer operatorId;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;
}