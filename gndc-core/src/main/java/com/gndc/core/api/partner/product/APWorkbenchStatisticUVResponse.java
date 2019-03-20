package com.gndc.core.api.partner.product;

import com.gndc.core.api.common.RequestMessage;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class APWorkbenchStatisticUVResponse implements Serializable {

    /**
     * 产品名
     */
    private String name;
    /**
     * 统计项：UV量
     */
    private String item;
    /**
     * 当前时段统计数
     */
    private Long currentPeriodCount;
    /**
     * 昨日同时段
     */
    private Long yesterSamePeriodCount;
    /**
     * 趋势：+16.81%
     */
    private String tendency;
}
