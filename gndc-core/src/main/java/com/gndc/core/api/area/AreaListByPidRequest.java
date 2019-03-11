/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.api.area;

import com.gndc.common.api.HjAction;
import com.gndc.common.api.RequestMessage;

/**
 * 根据pid查询下属城市列表
 *
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description
 * @date 2018年1月24日 下午2:33:31
 */
public class AreaListByPidRequest extends RequestMessage {

    private static final long serialVersionUID = 1L;

    private int pid;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public void createHeader() {
        super.createHeader();
        header.setAction(HjAction.C_AREA_LIST_BY_PID);
    }

}
