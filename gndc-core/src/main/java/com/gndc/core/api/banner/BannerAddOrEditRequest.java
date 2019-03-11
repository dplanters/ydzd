/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.api.banner;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

/**
 * @author <a href="jiangxin8116@adpanshi.com">jiangxin8116</a>
 * @version V1.0.1
 * @Description 广告 增加
 * @date 2018年1月24日 下午2:39:16
 */
public class BannerAddOrEditRequest extends RequestMessage {

    private static final long serialVersionUID = 1L;

    /**
     * 修改时需要传
     */
    private int bannerId;

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
     * 位置
     */
    private int position;

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.A_BANNER_SAVE);
    }

    public int getBannerId() {
        return bannerId;
    }

    public void setBannerId(int bannerId) {
        this.bannerId = bannerId;
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
     * @return position
     */
    public int getPosition() {
        return position;
    }

    /**
     * @param position 要设置的 position
     */
    public void setPosition(int position) {
        this.position = position;
    }

}
