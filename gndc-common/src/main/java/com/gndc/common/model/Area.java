package com.gndc.common.model;

import javax.persistence.*;

@Table(name = "dc_area")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 父级id
     */
    private Integer pid;

    /**
     * 所属区域，如中国华东，华南等
     */
    private Byte region;

    /**
     * 首字母，目前只整理了城市的
     */
    @Column(name = "first_char")
    private String firstChar;

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
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取父级id
     *
     * @return pid - 父级id
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置父级id
     *
     * @param pid 父级id
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 获取所属区域，如中国华东，华南等
     *
     * @return region - 所属区域，如中国华东，华南等
     */
    public Byte getRegion() {
        return region;
    }

    /**
     * 设置所属区域，如中国华东，华南等
     *
     * @param region 所属区域，如中国华东，华南等
     */
    public void setRegion(Byte region) {
        this.region = region;
    }

    /**
     * 获取首字母，目前只整理了城市的
     *
     * @return first_char - 首字母，目前只整理了城市的
     */
    public String getFirstChar() {
        return firstChar;
    }

    /**
     * 设置首字母，目前只整理了城市的
     *
     * @param firstChar 首字母，目前只整理了城市的
     */
    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar;
    }
}