/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.api;

import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageInfo;
import com.gndc.common.dto.AOAdminLoginInfoDTO;
import com.gndc.common.dto.APAdminLoginInfoDTO;
import com.gndc.common.dto.PUserLoginInfoDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description 请求基类封装
 * @date 2018年1月25日 上午9:49:09
 */
@Getter
@Setter
public class RequestMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Header header;
    protected PUserLoginInfoDTO pUser;
    protected AOAdminLoginInfoDTO aoAdmin;
    protected APAdminLoginInfoDTO apAdmin;

    public Integer getPageNum() {
        Integer pageNum = 1;
        PageInfo page = header.getPage();
        if (ObjectUtil.isNotNull(page)) {
            pageNum = page.getPageNum();
            if (ObjectUtil.isNull(pageNum) || pageNum < 1) {
                pageNum = 1;
                page.setPageNum(pageNum);
            }
        }
        return pageNum;
    }

    public Integer getPageSize() {
        Integer pageSize = 10;
        PageInfo page = header.getPage();
        if (ObjectUtil.isNotNull(page)) {
            pageSize = page.getPageSize();
            if (ObjectUtil.isNull(pageSize) || pageSize < 1) {
                pageSize = 10;
                page.setPageSize(pageSize);
            }
        }
        return pageSize;
    }
}
