/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.enums.user;

/**
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description 用户专属类型
 * @date 2018年1月24日 下午4:53:29
 */
public enum UserExclusiveType {

    SUPER_MARKET((byte) 1, "贷款产品"),

    CARD((byte) 2, "银行产品"),

    REPAY_MENT((byte) 3, "代还产品");

    private byte code;
    private String name;

    UserExclusiveType(byte code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getName(byte code) {
        for (UserExclusiveType userSexType : UserExclusiveType.values()) {
            if (userSexType.code == code) {
                return userSexType.name;
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
