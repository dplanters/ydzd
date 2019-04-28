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
 * @date 2019/4/27  13:59
 */
public enum ProductFormEnum {

    //产品形式 1：非授信产品；2：非循环授信产品；3：循环授信产品；4：授信产品；
    NO_CREDIT_GRANTING((byte)1,"非授信产品"),
    NO_LOOP_CREDIT_GRANTING((byte)1,"非授信产品"),
    LOOP_CREDIT_GRANTING((byte)1,"非授信产品"),
    CREDIT_GRANTING((byte)2,"月");

    private Byte code;
    private String name;

    ProductFormEnum(Byte code, String name) {
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
