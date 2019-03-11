/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.api.user;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

import java.util.List;
import java.util.Map;

/**
 * 图片上传接口
 *
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description
 * @date 2018年1月24日 下午2:35:06
 */
public class UploadImageRequest extends RequestMessage {

    /**
     * @Fields serialVersionUID:
     */
    private static final long serialVersionUID = 558605357014874485L;
    // 文件列表 [{"imageType":"", "imageBase64"：""}]
    private List<Map<String, String>> imageList;
    private String imageType;
    private String imageBase64;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.C_IMAGE_UPLOAD);
    }

    /**
     * @return imageType
     */
    public String getImageType() {
        return imageType;
    }

    /**
     * @param imageType 要设置的 imageType
     */
    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    /**
     * @return imageBase64
     */
    public String getImageBase64() {
        return imageBase64;
    }

    /**
     * @param imageBase64 要设置的 imageBase64
     */
    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    public List<Map<String, String>> getImageList() {
        return imageList;
    }

    public void setImageList(List<Map<String, String>> imageList) {
        this.imageList = imageList;
    }

}
