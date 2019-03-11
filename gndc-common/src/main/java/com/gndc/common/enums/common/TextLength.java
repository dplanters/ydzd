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
 * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
 * @version V1.0.1
 * @Description
 * @date 2018年5月15日 下午3:18:06
 */
public enum TextLength {

    SEVEN(7, 7),

    TEN(10, 10),

    TWENTY(20, 20),

    THIRTY(30, 30),

    FORTY(40, 40),

    FIFTY(50, 50),

    SIXTY(60, 60),

    SEVENTY(70, 70),

    EIGHTY(80, 80),

    NINETY(90, 90),

    ONE_HUNDRE(100, 100),

    TWO_HUNDRE(200, 200),

    THIRTY_HUNDRE(300, 300),

    TWO_HUNDRED_FIFTY_FIVE(255, 255),

    FORTY_HUNDRE(400, 400);

    private static final Map<Integer, TextLength> map;

    static {
        map = new HashMap<>();
        for (TextLength as : values()) {
            map.put(as.code, as);
        }
    }

    private int code;
    private int number;

    TextLength(int code, int number) {
        this.code = code;
        this.number = number;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static TextLength fetch(int code) {
        return map.get(code);
    }

    /**
     * 根据编码获取名称
     *
     * @param code
     * @return
     */

    public static int fetchLength(int code) {
        TextLength as = map.get(code);
        return as != null ? as.number : null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(byte code) {
        this.code = code;
    }

    public int getNumber() {
        return number;
    }

    public void setName(int number) {
        this.number = number;
    }

}
