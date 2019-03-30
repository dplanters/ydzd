package com.gndc.core.api.admin.product;

import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AOProductListRequest extends RequestMessage {

    /**
     * 合作模式
     */
    private Byte coopeMode;

    /**
     * 产品名
     */
    private String name;

    /**
     * 产品状态
     */
    private Byte productStatus;

    /**
     * 合作机构id
     */
    private Integer partnerId;

    /**
     * 开始时间
     */
    private String startDate;

    /**
     * 结束时间
     */
    private String endDate;

}
