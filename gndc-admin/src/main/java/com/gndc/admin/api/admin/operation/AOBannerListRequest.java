package com.gndc.admin.api.admin.operation;

import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AOBannerListRequest extends RequestMessage {

    /**
     * 状态
     */
    private Byte bannerStatus;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

}
