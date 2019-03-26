/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.enums.common;

/**
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description 删除状态
 * @date 2018年1月24日 下午4:48:34
 */
public enum StatusEnum {

    NORMAL((byte) 1, "正常状态"),

    DELETE((byte) 0, "伪删除状态 ");

    private byte code;
    private String name;

    StatusEnum(byte code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getName(byte code) {
        for (StatusEnum del : StatusEnum.values()) {
            if (del.code == code) {
                return del.name;
            }
        }
        return null;
    }

    public byte getCode() {
        return code;
    }

    public void setCode(byte code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
