/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.enums.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="litianwei8504@adpanshi.com">litianwei</a>
 * @version V1.0.1
 * @Description 状态枚举
 * @date 2018年8月8日 上午9:58:40
 */
public enum StatusType {

    NORMAL((byte) 1, "正常"),

    DISABLED((byte) -1, "禁用");

    private static final Map<Byte, StatusType> map;

    static {
        map = new HashMap<>();
        for (StatusType as : values()) {
            map.put(as.code, as);
        }
    }

    private byte code;
    private String name;

    StatusType(byte code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static StatusType fetch(byte code) {
        return map.get(code);
    }

    /**
     * 根据编码获取名称
     *
     * @param code
     * @return
     */
    public static String fetchName(byte code) {
        StatusType as = map.get(code);
        return as != null ? as.name : null;
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
