/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.etc.question;

import com.gndc.common.utils.DateUtil;
import com.gndc.core.model.CommonQuestion;

/**
 * @author <a href="litianwei8504@adpanshi.com">litianwei</a>
 * @version V1.0.1
 * @Description
 * @date 2018年8月20日 上午9:24:31
 */
public class ExCommonQuestion extends CommonQuestion {
    public String getStrCreateTime() {
        return DateUtil.timeToString(getCreateTime(), DateUtil.FORMAT_2);
    }

    public String getStrUpdateTime() {
        return DateUtil.timeToString(getUpdateTime(), DateUtil.FORMAT_2);
    }
}
