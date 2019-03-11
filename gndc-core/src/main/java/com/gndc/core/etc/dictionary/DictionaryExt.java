/**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.etc.dictionary;

import com.gndc.core.model.Dictionary;

import java.util.List;

/**
 * @author <a href="litianwei8504@adpanshi.com">litianwei</a>
 * @version V1.0.1
 * @Description
 * @date 2018年8月20日 下午4:37:38
 */
public class DictionaryExt extends Dictionary {
    private List<DictionaryExt> children;

    /**
     * @return children
     */
    public List<DictionaryExt> getChildren() {
        return children;
    }

    /**
     * @param children 要设置的 children
     */
    public void setChildren(List<DictionaryExt> children) {
        this.children = children;
    }

    /**
     * 获取
     *
     * @return
     * @Description
     * @author <a href="wangjie2355@adpanshi.com">wangjie</a>
     */
    public int getOptionValueInt() {
        try {
            return Integer.parseInt(getOptionValue());
        } catch (Exception e) {
            return 0;
        }
    }
}
