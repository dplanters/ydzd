/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.enums.common;

import com.gndc.common.constant.Constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="chenmeng8430@adpanshi.com">chenmeng</a>
 * @version V1.0.1
 * @Description 优惠券类型
 * @date 2018年7月10日 下午7:54:00
 */
public enum CouponType {

    FREE_AMOUNT((byte) 1, "免息金额", "IDR", "IDR", "VND", "PHP"),

    FREE_DAY((byte) 2, "免息天数", "hair", "Hair", "Ngày", "Days"),

    AMOUNT_REWARD((byte) 3, "奖励金额", "IDR", "IDR", "VND", "PHP"),

    INTEREST_DISCOUNT((byte) 4, "利息折扣", "%", "%", "%", "%"),

    OVERDUE_OFFER((byte) 5, "逾期优惠", "IDR", "IDR", "VND", "PHP");

    private static final Map<Byte, CouponType> map;

    static {
        map = new HashMap<>();
        for (CouponType as : values()) {
            map.put(as.code, as);
        }
    }

    private byte code;
    private String name;// 优惠项名称
    private String unit;// 优惠项单位
    private String IDUnit;// 印尼内容
    private String VNUnit;// 越南内容
    private String PHUnit;// 菲律宾内容

    CouponType(byte code, String name, String unit, String IDUnit, String VNUnit, String PHUnit) {
        this.code = code;
        this.name = name;
        this.unit = unit;
        this.IDUnit = IDUnit;
        this.VNUnit = VNUnit;
        this.PHUnit = PHUnit;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static CouponType fetch(byte code) {
        return map.get(code);
    }

    /**
     * 根据编码获取名称
     *
     * @param code
     * @return
     */
    public static String fetchName(byte code) {
        CouponType as = map.get(code);
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * 国际语言返回
     *
     * @return
     * @Description
     * @author <a href="jiangxin8116@adpanshi.com">jiangxin</a>
     */
    public String getI18NUnit() {

        if (Constant.COUNTRY.equals(CountryType.INDONESIA.getCode())) {
            return IDUnit;
        } else if (Constant.COUNTRY.equals(CountryType.VIETNAM.getCode())) {
            return VNUnit;
        } else if (Constant.COUNTRY.equals(CountryType.PHILIPPINES.getCode())) {
            return PHUnit;
        }
        return unit;
    }
}
