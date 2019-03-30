package com.gndc.core.api.admin.product;

import com.gndc.common.api.RequestMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AOProductHotListRequest extends RequestMessage {

    /**
     * 产品名
     */
    private String name;

    /**
     * 合作机构id
     */
    private Integer partnerId;
}
