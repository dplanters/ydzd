package com.gndc.core.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "dc_system_schedule_job")
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
     * 状态  1：正常；0：删除
     */
    private Byte status;

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
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取任务名
     *
     * @return job_name - 任务名
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * 设置任务名
     *
     * @param jobName 任务名
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * 获取任务执行时调用哪个类的方法 包名+类名
     *
     * @return bean_class - 任务执行时调用哪个类的方法 包名+类名
     */
    public String getBeanClass() {
        return beanClass;
    }

    /**
     * 设置任务执行时调用哪个类的方法 包名+类名
     *
     * @param beanClass 任务执行时调用哪个类的方法 包名+类名
     */
    public void setBeanClass(String beanClass) {
        this.beanClass = beanClass;
    }

    /**
     * 获取cron表达式
     *
     * @return cron_expression - cron表达式
     */
    public String getCronExpression() {
        return cronExpression;
    }

    /**
     * 设置cron表达式
     *
     * @param cronExpression cron表达式
     */
    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    /**
     * 获取任务调用的方法名
     *
     * @return method_name - 任务调用的方法名
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * 设置任务调用的方法名
     *
     * @param methodName 任务调用的方法名
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    /**
     * 获取是否同步1：同步0：不同步
     *
     * @return is_concurrent - 是否同步1：同步0：不同步
     */
    public Byte getIsConcurrent() {
        return isConcurrent;
    }

    /**
     * 设置是否同步1：同步0：不同步
     *
     * @param isConcurrent 是否同步1：同步0：不同步
     */
    public void setIsConcurrent(Byte isConcurrent) {
        this.isConcurrent = isConcurrent;
    }

    /**
     * 获取任务描述
     *
     * @return description - 任务描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置任务描述
     *
     * @param description 任务描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取任务状态1：开始0：停止
     *
     * @return job_status - 任务状态1：开始0：停止
     */
    public Byte getJobStatus() {
        return jobStatus;
    }

    /**
     * 设置任务状态1：开始0：停止
     *
     * @param jobStatus 任务状态1：开始0：停止
     */
    public void setJobStatus(Byte jobStatus) {
        this.jobStatus = jobStatus;
    }

    /**
     * 获取任务分组
     *
     * @return job_group - 任务分组
     */
    public String getJobGroup() {
        return jobGroup;
    }

    /**
     * 设置任务分组
     *
     * @param jobGroup 任务分组
     */
    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    /**
     * 获取拓展条件id
     *
     * @return extend_id - 拓展条件id
     */
    public Integer getExtendId() {
        return extendId;
    }

    /**
     * 设置拓展条件id
     *
     * @param extendId 拓展条件id
     */
    public void setExtendId(Integer extendId) {
        this.extendId = extendId;
    }

    /**
     * 获取状态  1：正常；0：删除
     *
     * @return status - 状态  1：正常；0：删除
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态  1：正常；0：删除
     *
     * @param status 状态  1：正常；0：删除
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取创建者id
     *
     * @return create_admin_id - 创建者id
     */
    public Integer getCreateAdminId() {
        return createAdminId;
    }

    /**
     * 设置创建者id
     *
     * @param createAdminId 创建者id
     */
    public void setCreateAdminId(Integer createAdminId) {
        this.createAdminId = createAdminId;
    }

    /**
     * 获取更新者id
     *
     * @return update_admin_id - 更新者id
     */
    public Integer getUpdateAdminId() {
        return updateAdminId;
    }

    /**
     * 设置更新者id
     *
     * @param updateAdminId 更新者id
     */
    public void setUpdateAdminId(Integer updateAdminId) {
        this.updateAdminId = updateAdminId;
    }
}