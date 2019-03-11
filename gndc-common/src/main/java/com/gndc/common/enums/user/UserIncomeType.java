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
 * @author <a href="jiangxin8116@adpanshi.com">jiangxin8116</a>
 * @version V1.0.1
 * @Description 用户收入范围
 * @date 2018年1月24日
 */
public enum UserIncomeType {

    INCOME_ONE((byte) 1, 2999),
    INCOME_TWO((byte) 2, 3000),
    INCOME_THREE((byte) 3, 5000),
    INCOME_FOUR((byte) 4, 10000),
    INCOME_FIVE((byte) 5, 15000);

    private byte code;
    private int income;

    UserIncomeType(byte code, int income) {
        this.code = code;
        this.income = income;
    }

    public static int getIncome(byte code) {
        for (UserIncomeType userIncomeType : UserIncomeType.values()) {
            if (userIncomeType.code == code) {
                return userIncomeType.income;
            }
        }
        return 0;
    }

    public byte getCode() {
        return code;
    }

    public void setCode(byte code) {
        this.code = code;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }
}
