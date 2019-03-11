/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.enums.common;

/**
 * 文件类型
 *
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description
 * @date 2018年3月31日 下午7:42:34
 */
public enum FileType {

    HEAD_PHOTO("head", "用户头像"),

    IMAGE("image", "图片");

    private String code;
    private String name;

    FileType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getName(String code) {
        for (FileType ft : FileType.values()) {
            if (ft.code.equals(code)) {
                return ft.name;
            }
        }
        return null;
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
