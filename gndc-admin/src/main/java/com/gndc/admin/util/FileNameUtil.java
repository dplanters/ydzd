/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.admin.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author <a href="liujun8852@adpanshi.com">liujun</a>
 * @version V1.0.1
 * @Description
 * @date 2019/5/5  16:47
 */
public class FileNameUtil {

    // 解决设置名称时的乱码
    public static String processFileName(HttpServletRequest request, String fileNames) {
        String codedfilename = null;
        try {
            String agent = request.getHeader("USER-AGENT");
            if (null != agent && -1 != agent.indexOf("MSIE") || null != agent && -1 != agent.indexOf("Trident")) {// ie

                String name = java.net.URLEncoder.encode(fileNames, "UTF8");

                codedfilename = name;
            } else if (null != agent && -1 != agent.indexOf("Mozilla")) {// 火狐,chrome等

                codedfilename = new String(fileNames.getBytes("UTF-8"), "iso-8859-1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return codedfilename;
    }
}
