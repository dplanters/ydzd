package com.gndc.core.etc.banner;

import com.gndc.common.utils.DateUtil;
import com.gndc.core.model.Banner;
import org.apache.commons.lang.StringUtils;

public class ExBanner extends Banner {
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

    public String getStrCreateTime() {
        return DateUtil.timeToString(getCreateTime(), DateUtil.FORMAT_2);
    }

    public String getStrUpdateTime() {
        return DateUtil.timeToString(getUpdateTime(), DateUtil.FORMAT_2);
    }

    public String getStrBeginTime() {
        return DateUtil.timeToString(getBeginTime(), DateUtil.FORMAT_2);
    }

    public String getStrEndTime() {
        return DateUtil.timeToString(getEndTime(), DateUtil.FORMAT_2);
    }

    public String getStrPicUrl() {
        if (StringUtils.isNotBlank(getImgUrl())) {
            return getImgUrl();
        }
        return null;
    }
}