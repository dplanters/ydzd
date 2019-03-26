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
     * 任务是否有状态
     */
    @Column(name = "is_concurrent")
    private String isConcurrent;

    /**
     * 任务描述
     */
    private String description;

    /**
     * 任务执行时调用哪个类的方法 包名+类名
     */
    @Column(name = "bean_class")
    private String beanClass;

    /**
     * 任务状态
     */
    @Column(name = "job_status")
    private String jobStatus;

    /**
     * 任务分组
     */
    @Column(name = "job_group")
    private String jobGroup;

    /**
     * 状态  1存在；-1删除
     */
    @Column(name = "is_del")
    private Byte isDel;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 创建者id
     */
    @Column(name = "create_admin_id")
    private Integer createAdminId;

    /**
     * 更新者id
     */
    @Column(name = "update_admin_id")
    private Integer updateAdminId;

    /**
     * Spring bean
     */
    @Column(name = "spring_bean")
    private String springBean;
}