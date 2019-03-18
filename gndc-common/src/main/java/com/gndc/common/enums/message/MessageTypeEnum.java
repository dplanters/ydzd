/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.enums.message;

import java.util.HashMap;
import java.util.Map;

/**
 * 消息结果类型
 *
 * @author <a href="jiangxin8116@adpanshi.com">jiangxin8116</a>
 * @version V1.0.1
 * @Description
 * @date 2018年1月25日 上午9:58:40
 */
public enum MessageTypeEnum {

    SYSTEM((byte) 1, "系统通知"),

    ORDER((byte) 2, "订单通知"),

    IN_OR_OUT((byte) 3, "收支通知"),

    ORDER_RETURN((byte) 4, "资料退回"),

    USERCOUPON_REMINDER((byte) 5, "优惠卷到期提醒");

    private static final Map<Byte, MessageTypeEnum> map;

    static {
        map = new HashMap<>();
        for (MessageTypeEnum as : values()) {
            map.put(as.code, as);
        }
    }

    private byte code;
    private String name;

    MessageTypeEnum(byte code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 根据编码获取状态
     *
     * @param code
     * @return
     */
    public static MessageTypeEnum fetch(byte code) {
        return map.get(code);
    }

    /**
     * 根据编码获取名称
     *
     * @param code
     * @return
     */
    public static String fetchName(byte code) {
        MessageTypeEnum as = map.get(code);
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
