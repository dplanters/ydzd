/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.api.advertis;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

/**
 * @author <a href="litianwei8504@adpanshi.com">litianwei</a>
 * @version V1.0.1
 * @Description 广告 增加，修改
 * @date 2018年1月24日 下午2:39:16
 */
public class AdvertisAddOrEditRequest extends RequestMessage {

    private static final long serialVersionUID = 1L;

    /**
     * 修改时需要传
     */
    private int Id;

    /**
     * 图片路径
     */
    private String pic;

    /**
     * 图片类型 如jpg jpeg png gif
     */
    private String picType;

    /**
     * 链接URL
     */
    private String link;

    /**
     * 产品id
     */
    private int productId;

    /**
     * 类型
     */
    private int type;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.ADVERTIS_ADD_EDIT);
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    /**
     * @return link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link 要设置的 link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * @return productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     * @param productId 要设置的 productId
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getPicType() {
        return picType;
    }

    public void setPicType(String picType) {
        this.picType = picType;
    }

    /**
     * @return id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param id 要设置的 id
     */
    public void setId(int id) {
        Id = id;
    }

    /**
     * @return type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type 要设置的 type
     */
    public void setType(int type) {
        this.type = type;
    }

}
