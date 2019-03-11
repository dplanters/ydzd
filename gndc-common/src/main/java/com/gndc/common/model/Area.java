package com.gndc.common.model;

import java.util.List;

public class Area {
    /**
     *
     */
    private int id;

    /**
     * 名称
     */
    private String name;

    /**
     * 父级id
     */
    private int pid;

    /**
     * 所属区域，如中国华东，华南等
     */
    private byte region;

    /**
     * 首字母，目前只整理了城市的
     */
    private String firstChar;

    /**
     * 下级城市列表
     */
    private List<Area> children;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public byte getRegion() {
        return region;
    }

    public void setRegion(byte region) {
        this.region = region;
    }

    public String getFirstChar() {
        return firstChar;
    }

    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar;
    }

    public List<Area> getChildren() {
        return children;
    }

    public void setChildren(List<Area> children) {
        this.children = children;
    }

}