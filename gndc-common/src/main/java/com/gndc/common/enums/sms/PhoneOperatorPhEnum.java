/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.enums.sms;

import java.util.HashMap;
import java.util.Map;

/**
 * 菲律宾电话运营商
 *
 * @author <a href="litianwei8504@adpanshi.com">litianwei</a>
 * @version V1.0.1
 * @Description
 * @date 2018年7月26日 上午10:31:46
 */
public enum PhoneOperatorPhEnum {

    SMART("S", "smart"),

    GLOBE("G", "globe"),

    OTHER("X", "unkonw");

    private static final Map<String, PhoneOperatorPhEnum> map;

    static {
        map = new HashMap<>();
        for (PhoneOperatorPhEnum as : values()) {
            map.put(as.code, as);
        }
    }

    private String code;
    private String name;

    PhoneOperatorPhEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static PhoneOperatorPhEnum fetch(String code) {
        return map.get(code);
    }

    /**
     * 根据编码获取名称
     *
     * @param code
     * @return
     */
    public static String fetchName(String code) {
        PhoneOperatorPhEnum sc = map.get(code);
        return sc != null ? sc.name : null;
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code 要设置的 code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 要设置的 name
     */
    public void setName(String name) {
        this.name = name;
    }

}
