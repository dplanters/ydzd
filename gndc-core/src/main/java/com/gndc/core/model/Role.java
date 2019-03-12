package com.gndc.core.model;

import com.gndc.common.model.BaseEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dc_role")
public class Role extends BaseEntity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_role.id
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_role.role_name
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private String roleName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_role.status
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private Byte status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_role.create_admin_id
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private Integer createAdminId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_role.update_admin_id
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private Integer updateAdminId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_role.id
     *
     * @return the value of dc_role.id
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_role.id
     *
     * @param id the value for dc_role.id
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_role.role_name
     *
     * @return the value of dc_role.role_name
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_role.role_name
     *
     * @param roleName the value for dc_role.role_name
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_role.status
     *
     * @return the value of dc_role.status
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_role.status
     *
     * @param status the value for dc_role.status
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_role.create_admin_id
     *
     * @return the value of dc_role.create_admin_id
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public Integer getCreateAdminId() {
        return createAdminId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_role.create_admin_id
     *
     * @param createAdminId the value for dc_role.create_admin_id
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setCreateAdminId(Integer createAdminId) {
        this.createAdminId = createAdminId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_role.update_admin_id
     *
     * @return the value of dc_role.update_admin_id
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public Integer getUpdateAdminId() {
        return updateAdminId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_role.update_admin_id
     *
     * @param updateAdminId the value for dc_role.update_admin_id
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setUpdateAdminId(Integer updateAdminId) {
        this.updateAdminId = updateAdminId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_role
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Role other = (Role) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getRoleName() == null ? other.getRoleName() == null : this.getRoleName().equals(other.getRoleName()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getCreateAdminId() == null ? other.getCreateAdminId() == null : this.getCreateAdminId().equals(other.getCreateAdminId()))
                && (this.getUpdateAdminId() == null ? other.getUpdateAdminId() == null : this.getUpdateAdminId().equals(other.getUpdateAdminId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_role
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRoleName() == null) ? 0 : getRoleName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateAdminId() == null) ? 0 : getCreateAdminId().hashCode());
        result = prime * result + ((getUpdateAdminId() == null) ? 0 : getUpdateAdminId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_role
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleName=").append(roleName);
        sb.append(", status=").append(status);
        sb.append(", createAdminId=").append(createAdminId);
        sb.append(", updateAdminId=").append(updateAdminId);
        sb.append("]");
        return sb.toString();
    }
}