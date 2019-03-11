package com.gndc.core.etc.admin;

import com.gndc.common.model.Right;
import com.gndc.common.utils.DateUtil;

import java.util.Date;
import java.util.List;

public class Role {
    /**
     *
     */
    private Integer id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色说明
     */
    private String roleDesc;

    /**
     * 显示顺序
     */
    private Integer roleOrder;

    /**
     * 角色所属类别(暂不用)
     */
    private Integer roleType;

    /**
     * 状态(1启用，-1不启用)
     */
    private Byte roleStatus;

    /**
     * 操作人工号
     */
    private Integer operId;

    /**
     * 操作人工号
     */
    private int createAdminId;

    /**
     * 最后一次操作人工号
     */
    private int updateAdminId;

    /**
     * 操作时间
     */
    private Date createTime;

    /**
     * 最后一次操作人工号
     */
    private Integer lastOper;

    /**
     * 最后一次操作时间
     */
    private Date updateTime;

    /**
     * 冗余字段角色权限
     */
    private List<RoleRight> roleRights;

    /**
     * 冗余字段角色权限
     */
    private List<Right> rightList;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 要设置的 id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName 要设置的 roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * @return roleDesc
     */
    public String getRoleDesc() {
        return roleDesc;
    }

    /**
     * @param roleDesc 要设置的 roleDesc
     */
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    /**
     * @return roleOrder
     */
    public Integer getRoleOrder() {
        return roleOrder;
    }

    /**
     * @param roleOrder 要设置的 roleOrder
     */
    public void setRoleOrder(Integer roleOrder) {
        this.roleOrder = roleOrder;
    }

    /**
     * @return roleType
     */
    public Integer getRoleType() {
        return roleType;
    }

    /**
     * @param roleType 要设置的 roleType
     */
    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    /**
     * @return roleStatus
     */
    public Byte getRoleStatus() {
        return roleStatus;
    }

    /**
     * @param roleStatus 要设置的 roleStatus
     */
    public void setRoleStatus(Byte roleStatus) {
        this.roleStatus = roleStatus;
    }

    /**
     * @return operId
     */
    public Integer getOperId() {
        return operId;
    }

    /**
     * @param operId 要设置的 operId
     */
    public void setOperId(Integer operId) {
        this.operId = operId;
    }

    /**
     * @return lastOper
     */
    public Integer getLastOper() {
        return lastOper;
    }

    /**
     * @param lastOper 要设置的 lastOper
     */
    public void setLastOper(Integer lastOper) {
        this.lastOper = lastOper;
    }

    /**
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime 要设置的 createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime 要设置的 updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return createAdminId
     */
    public int getCreateAdminId() {
        return createAdminId;
    }

    /**
     * @param createAdminId 要设置的 createAdminId
     */
    public void setCreateAdminId(int createAdminId) {
        this.createAdminId = createAdminId;
    }

    /**
     * @return updateAdminId
     */
    public int getUpdateAdminId() {
        return updateAdminId;
    }

    /**
     * @param updateAdminId 要设置的 updateAdminId
     */
    public void setUpdateAdminId(int updateAdminId) {
        this.updateAdminId = updateAdminId;
    }

    /**
     * @return roleRights
     */
    public List<RoleRight> getRoleRights() {
        return roleRights;
    }

    /**
     * @param roleRights 要设置的 roleRights
     */
    public void setRoleRights(List<RoleRight> roleRights) {
        this.roleRights = roleRights;
    }

    public String getStrCreateTime() {
        return DateUtil.timeToString(this.createTime, DateUtil.FORMAT_2);
    }

    /**
     * @return rightList
     */
    public List<Right> getRightList() {
        return rightList;
    }

    /**
     * @param rightList 要设置的 rightList
     */
    public void setRightList(List<Right> rightList) {
        this.rightList = rightList;
    }

    public String getStrUpdateTime() {
        return DateUtil.timeToString(this.updateTime, DateUtil.FORMAT_2);
    }
}