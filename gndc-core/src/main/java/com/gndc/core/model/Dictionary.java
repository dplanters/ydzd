package com.gndc.core.model;

import com.gndc.common.model.BaseEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "dc_dict")
public class Dictionary extends BaseEntity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_dict.id
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_dict.option_group
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private String optionGroup;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_dict.option_value
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private String optionValue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_dict.option_name
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private String optionName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_dict.option_name_cn
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private String optionNameCn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_dict.supper_value
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private String supperValue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_dict.status
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private Byte status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_dict.remark
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dc_dict.remark_cn
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    private String remarkCn;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_dict.id
     *
     * @return the value of dc_dict.id
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_dict.id
     *
     * @param id the value for dc_dict.id
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_dict.option_group
     *
     * @return the value of dc_dict.option_group
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public String getOptionGroup() {
        return optionGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_dict.option_group
     *
     * @param optionGroup the value for dc_dict.option_group
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setOptionGroup(String optionGroup) {
        this.optionGroup = optionGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_dict.option_value
     *
     * @return the value of dc_dict.option_value
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public String getOptionValue() {
        return optionValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_dict.option_value
     *
     * @param optionValue the value for dc_dict.option_value
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_dict.option_name
     *
     * @return the value of dc_dict.option_name
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public String getOptionName() {
        return optionName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_dict.option_name
     *
     * @param optionName the value for dc_dict.option_name
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_dict.option_name_cn
     *
     * @return the value of dc_dict.option_name_cn
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public String getOptionNameCn() {
        return optionNameCn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_dict.option_name_cn
     *
     * @param optionNameCn the value for dc_dict.option_name_cn
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setOptionNameCn(String optionNameCn) {
        this.optionNameCn = optionNameCn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_dict.supper_value
     *
     * @return the value of dc_dict.supper_value
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public String getSupperValue() {
        return supperValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_dict.supper_value
     *
     * @param supperValue the value for dc_dict.supper_value
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setSupperValue(String supperValue) {
        this.supperValue = supperValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_dict.status
     *
     * @return the value of dc_dict.status
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_dict.status
     *
     * @param status the value for dc_dict.status
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_dict.remark
     *
     * @return the value of dc_dict.remark
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_dict.remark
     *
     * @param remark the value for dc_dict.remark
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dc_dict.remark_cn
     *
     * @return the value of dc_dict.remark_cn
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public String getRemarkCn() {
        return remarkCn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dc_dict.remark_cn
     *
     * @param remarkCn the value for dc_dict.remark_cn
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    public void setRemarkCn(String remarkCn) {
        this.remarkCn = remarkCn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_dict
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
        Dictionary other = (Dictionary) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getOptionGroup() == null ? other.getOptionGroup() == null : this.getOptionGroup().equals(other.getOptionGroup()))
                && (this.getOptionValue() == null ? other.getOptionValue() == null : this.getOptionValue().equals(other.getOptionValue()))
                && (this.getOptionName() == null ? other.getOptionName() == null : this.getOptionName().equals(other.getOptionName()))
                && (this.getOptionNameCn() == null ? other.getOptionNameCn() == null : this.getOptionNameCn().equals(other.getOptionNameCn()))
                && (this.getSupperValue() == null ? other.getSupperValue() == null : this.getSupperValue().equals(other.getSupperValue()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
                && (this.getRemarkCn() == null ? other.getRemarkCn() == null : this.getRemarkCn().equals(other.getRemarkCn()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_dict
     *
     * @mbggenerated Sat Aug 18 18:25:21 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOptionGroup() == null) ? 0 : getOptionGroup().hashCode());
        result = prime * result + ((getOptionValue() == null) ? 0 : getOptionValue().hashCode());
        result = prime * result + ((getOptionName() == null) ? 0 : getOptionName().hashCode());
        result = prime * result + ((getOptionNameCn() == null) ? 0 : getOptionNameCn().hashCode());
        result = prime * result + ((getSupperValue() == null) ? 0 : getSupperValue().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getRemarkCn() == null) ? 0 : getRemarkCn().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dc_dict
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
        sb.append(", optionGroup=").append(optionGroup);
        sb.append(", optionValue=").append(optionValue);
        sb.append(", optionName=").append(optionName);
        sb.append(", optionNameCn=").append(optionNameCn);
        sb.append(", supperValue=").append(supperValue);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", remarkCn=").append(remarkCn);
        sb.append("]");
        return sb.toString();
    }
}