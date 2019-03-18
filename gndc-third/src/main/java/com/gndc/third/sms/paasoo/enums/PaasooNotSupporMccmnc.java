/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.third.sms.paasoo.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 短信运营商枚举
 *
 * @author <a href="litianwei8504@adpanshi.com">litianwei</a>
 * @version V1.0.1
 * @Description
 * @date 2018年6月21日 上午10:50:51
 */
public enum PaasooNotSupporMccmnc {

    MCCMNC_45204("45204", "Viettel Corp"),

    MCCMNC_ID_FIXED("ID-FIXED", "ID-FIXED"),

    MCCMNC_ID_UNKNOWN("ID-UNKNOWN", "ID-UNKNOWN");

    private static final Map<String, PaasooNotSupporMccmnc> map;

    static {
        map = new HashMap<>();
        for (PaasooNotSupporMccmnc as : values()) {
            map.put(as.code, as);
        }
    }

    private String code;
    private String name;

    PaasooNotSupporMccmnc(String code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static PaasooNotSupporMccmnc fetch(String code) {
        return map.get(code);
    }

    /**
     * 根据编码获取名称
     *
     * @param code
     * @return
     */
    public static String fetchName(String code) {
        PaasooNotSupporMccmnc sc = map.get(code);
        return sc != null ? sc.name : null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
