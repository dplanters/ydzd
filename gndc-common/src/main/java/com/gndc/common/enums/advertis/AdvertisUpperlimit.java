/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.enums.advertis;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="litianwei8504@adpanshi.com">litianwei</a>
 * @version V1.0.1
 * @Description 广告上线限制枚举
 * @date 2018年8月16日 下午2:44:17
 */
public enum AdvertisUpperlimit {

    POP_UPS((byte) 1, "弹窗广告"),

    OPEN_SCREEN((byte) 2, "开屏广告"),

    BANNER((byte) 4, "banner"),

    ;

    private static final Map<Byte, AdvertisUpperlimit> map;

    static {
        map = new HashMap<>();
        for (AdvertisUpperlimit as : values()) {
            map.put(as.code, as);
        }
    }

    private byte code;
    private String name;

    AdvertisUpperlimit(byte code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static AdvertisUpperlimit fetch(byte code) {
        return map.get(code);
    }

    /**
     * 根据编码获取名称
     *
     * @param code
     * @return
     */
    public static String fetchName(byte code) {
        AdvertisUpperlimit as = map.get(code);
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
