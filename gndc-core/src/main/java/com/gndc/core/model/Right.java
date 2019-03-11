package com.gndc.core.model;

import com.gndc.common.model.BaseEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dc_right")
public class Right extends BaseEntity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_right.id
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_right.right_status
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private Byte rightStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_right.right_name
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private String rightName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_right.right_url
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private String rightUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_right.supper_id
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private Integer supperId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_right.right_type
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private Byte rightType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_right.right_order
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private Integer rightOrder;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_right.right_pic
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private String rightPic;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_right.unique_sign
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private String uniqueSign;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_right.right_level
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private Byte rightLevel;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_right.id
     *
     * @return the value of dc_right.id
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_right.id
     *
     * @param id the value for dc_right.id
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_right.right_status
     *
     * @return the value of dc_right.right_status
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public Byte getRightStatus() {
        return rightStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_right.right_status
     *
     * @param rightStatus the value for dc_right.right_status
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setRightStatus(Byte rightStatus) {
        this.rightStatus = rightStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_right.right_name
     *
     * @return the value of dc_right.right_name
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public String getRightName() {
        return rightName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_right.right_name
     *
     * @param rightName the value for dc_right.right_name
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setRightName(String rightName) {
        this.rightName = rightName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_right.right_url
     *
     * @return the value of dc_right.right_url
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public String getRightUrl() {
        return rightUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_right.right_url
     *
     * @param rightUrl the value for dc_right.right_url
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setRightUrl(String rightUrl) {
        this.rightUrl = rightUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_right.supper_id
     *
     * @return the value of dc_right.supper_id
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public Integer getSupperId() {
        return supperId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_right.supper_id
     *
     * @param supperId the value for dc_right.supper_id
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setSupperId(Integer supperId) {
        this.supperId = supperId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_right.right_type
     *
     * @return the value of dc_right.right_type
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public Byte getRightType() {
        return rightType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_right.right_type
     *
     * @param rightType the value for dc_right.right_type
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setRightType(Byte rightType) {
        this.rightType = rightType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_right.right_order
     *
     * @return the value of dc_right.right_order
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public Integer getRightOrder() {
        return rightOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_right.right_order
     *
     * @param rightOrder the value for dc_right.right_order
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setRightOrder(Integer rightOrder) {
        this.rightOrder = rightOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_right.right_pic
     *
     * @return the value of dc_right.right_pic
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public String getRightPic() {
        return rightPic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_right.right_pic
     *
     * @param rightPic the value for dc_right.right_pic
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setRightPic(String rightPic) {
        this.rightPic = rightPic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_right.unique_sign
     *
     * @return the value of dc_right.unique_sign
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public String getUniqueSign() {
        return uniqueSign;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_right.unique_sign
     *
     * @param uniqueSign the value for dc_right.unique_sign
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setUniqueSign(String uniqueSign) {
        this.uniqueSign = uniqueSign;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_right.right_level
     *
     * @return the value of dc_right.right_level
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public Byte getRightLevel() {
        return rightLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_right.right_level
     *
     * @param rightLevel the value for dc_right.right_level
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setRightLevel(Byte rightLevel) {
        this.rightLevel = rightLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_right
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
        Right other = (Right) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getRightStatus() == null ? other.getRightStatus() == null : this.getRightStatus().equals(other.getRightStatus()))
                && (this.getRightName() == null ? other.getRightName() == null : this.getRightName().equals(other.getRightName()))
                && (this.getRightUrl() == null ? other.getRightUrl() == null : this.getRightUrl().equals(other.getRightUrl()))
                && (this.getSupperId() == null ? other.getSupperId() == null : this.getSupperId().equals(other.getSupperId()))
                && (this.getRightType() == null ? other.getRightType() == null : this.getRightType().equals(other.getRightType()))
                && (this.getRightOrder() == null ? other.getRightOrder() == null : this.getRightOrder().equals(other.getRightOrder()))
                && (this.getRightPic() == null ? other.getRightPic() == null : this.getRightPic().equals(other.getRightPic()))
                && (this.getUniqueSign() == null ? other.getUniqueSign() == null : this.getUniqueSign().equals(other.getUniqueSign()))
                && (this.getRightLevel() == null ? other.getRightLevel() == null : this.getRightLevel().equals(other.getRightLevel()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_right
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRightStatus() == null) ? 0 : getRightStatus().hashCode());
        result = prime * result + ((getRightName() == null) ? 0 : getRightName().hashCode());
        result = prime * result + ((getRightUrl() == null) ? 0 : getRightUrl().hashCode());
        result = prime * result + ((getSupperId() == null) ? 0 : getSupperId().hashCode());
        result = prime * result + ((getRightType() == null) ? 0 : getRightType().hashCode());
        result = prime * result + ((getRightOrder() == null) ? 0 : getRightOrder().hashCode());
        result = prime * result + ((getRightPic() == null) ? 0 : getRightPic().hashCode());
        result = prime * result + ((getUniqueSign() == null) ? 0 : getUniqueSign().hashCode());
        result = prime * result + ((getRightLevel() == null) ? 0 : getRightLevel().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_right
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
        sb.append(", rightStatus=").append(rightStatus);
        sb.append(", rightName=").append(rightName);
        sb.append(", rightUrl=").append(rightUrl);
        sb.append(", supperId=").append(supperId);
        sb.append(", rightType=").append(rightType);
        sb.append(", rightOrder=").append(rightOrder);
        sb.append(", rightPic=").append(rightPic);
        sb.append(", uniqueSign=").append(uniqueSign);
        sb.append(", rightLevel=").append(rightLevel);
        sb.append("]");
        return sb.toString();
    }
}