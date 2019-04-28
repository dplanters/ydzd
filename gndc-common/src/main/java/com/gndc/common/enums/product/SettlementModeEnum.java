/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.enums.product;

/**
 * @author <a href="liujun8852@adpanshi.com">liujun</a>
 * @version V1.0.1
 * @Description
 * @date 2019/4/27  14:17
 */
public enum  SettlementModeEnum {

    // 结算模式 1：UV浏览量（每天仅记一次）；2：注册推送（注册成功即收费）；3：下载收费（下载一次收费一次）；4：API计费；5：API加提成收费；
    UV((byte)1,"UV浏览量（每天仅记一次）"),
    REGISTER_PUSH((byte)2,"注册推送（注册成功即收费）"),
    DOWNLOAD((byte)3,"下载收费（下载一次收费一次）"),
    API((byte)4,"API计费"),
    API_AND_EXTRA_INCOME((byte)5,"API加提成收费");

    private Byte code;
    private String name;

    SettlementModeEnum(Byte code, String name) {
        this.code = code;
        this.name = name;
    }

    public Byte getCode() {
        return code;
    }

    public void setCode(Byte code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
