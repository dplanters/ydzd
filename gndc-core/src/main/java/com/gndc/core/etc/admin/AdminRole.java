package com.gndc.core.etc.admin;

public class AdminRole {

    /**
     * 管理员id
     */
    private int adminId;

    /**
     * 角色id
     */
    private int roleId;

    /**
     * 状态
     */
    private byte status;

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

}