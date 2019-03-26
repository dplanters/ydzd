package com.gndc.core.api.admin.operation;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
