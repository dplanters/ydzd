/**************************************************************************
 * Copyright (c) 2013-2023  浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.enums.appsflyer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
 * @version V1.0.1
 * @Description appsflyer回调类型枚举
 * @date 2018年1月25日 上午9:58:10
 */
public enum AppsFlyerNotifyType {

    NO_CALL_BACK((byte) 1, "未回调", "NO_CALL_BACK"),

    CALL_BACK((byte) 2, "已回调", "CALL_BACK");

    private static final Map<Byte, AppsFlyerNotifyType> map;

    static {
        map = new HashMap<>();
        for (AppsFlyerNotifyType as : values()) {
            map.put(as.code, as);
        }
    }

    private byte code;
    private String nameCN;
    private String name;

    AppsFlyerNotifyType(byte code, String nameCN, String name) {
        this.code = code;
        this.nameCN = nameCN;
        this.name = name;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static AppsFlyerNotifyType fetch(byte code) {
        return map.get(code);
    }

    /**
     * 根据编码获取名称
     *
     * @param code
     * @return
     */
    public static String fetchNameCN(byte code) {
        AppsFlyerNotifyType as = map.get(code);
        return as != null ? as.nameCN : null;
    }

    public byte getCode() {
        return code;
    }

    public void setCode(byte code) {
        this.code = code;
    }

    public String getNameCN() {
        return nameCN;
    }

    public void setNameCN(String nameCN) {
        this.nameCN = nameCN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
