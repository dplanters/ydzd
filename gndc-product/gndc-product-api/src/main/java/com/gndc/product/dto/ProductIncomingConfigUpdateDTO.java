/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.product.dto;

import com.gndc.product.model.ProductIncomingConfig;
import lombok.Data;

import java.io.Serializable;

/**
 * @author <a href="liujun8852@adpanshi.com">liujun</a>
 * @version V1.0.1
 * @Description
 * @date 2019/4/30  9:49
 */
@Data
public class ProductIncomingConfigUpdateDTO implements Serializable {


    private Integer sameDayNewUser;//当日新客已进件数量
    private Integer sameDayOldUser;//当日老客已进件数量
    private Integer newUser;//新客已进件数量  总数
    private Integer oldUser;//老客已进件数量 总数
    private Integer totalUser;

    private ProductIncomingConfig productIncomingConfig;

    public Integer getTotalUser() {
        return newUser+oldUser;
    }
}
