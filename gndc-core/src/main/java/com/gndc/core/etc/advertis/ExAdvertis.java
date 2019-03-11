/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.etc.advertis;

import com.gndc.common.enums.advertis.AdvertisType;
import com.gndc.common.utils.DateUtil;
import com.gndc.core.model.Advertis;
import org.apache.commons.lang.StringUtils;

/**
 * @author <a href="litianwei8504@adpanshi.com">litianwei</a>
 * @version V1.0.1
 * @Description
 * @date 2018年8月18日 下午5:46:48
 */
public class ExAdvertis extends Advertis {

    // 产品名称
    private String name;

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 要设置的 name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public String getStrAdvertisType() {
        return AdvertisType.fetchName(getAdvertisType());
    }

    public String getStrCreateTime() {
        return DateUtil.timeToString(getCreateTime(), DateUtil.FORMAT_2);
    }

    public String getStrUpdateTime() {
        return DateUtil.timeToString(getUpdateTime(), DateUtil.FORMAT_2);
    }

    public String getStrPicUrl() {
        if (StringUtils.isNotBlank(getImgUrl())) {
            return getImgUrl();
        }
        return null;
    }
}
