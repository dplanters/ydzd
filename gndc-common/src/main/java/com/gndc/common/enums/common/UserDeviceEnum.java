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
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description 登录设备
 * @date 2018年1月24日 下午4:50:02
 */
public enum UserDeviceEnum {
    WECAT((byte) 2, "微信"),

    PC((byte) 3, "PC"),

    ANDROID((byte) 4, "android"),

    IOS((byte) 5, "ios");

    private static final Map<Byte, UserDeviceEnum> map;

    static {
        map = new HashMap<>();
        for (UserDeviceEnum as : values()) {
            map.put(as.code, as);
        }
    }

    private byte code;
    private String name;

    UserDeviceEnum(byte code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static UserDeviceEnum fetch(byte code) {
        return map.get(code);
    }

    /**
     * 根据编码获取名称
     *
     * @param code
     * @return
     */
    public static String fetchName(byte code) {
        UserDeviceEnum as = map.get(code);
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
